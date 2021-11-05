import java.util.ArrayList;

public class OrderList {
    private final ArrayList<Order> orderList = new ArrayList<>();

    // Returnerer ordrelisten
    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    // Skaber en ordrer med informationer fra brugeren og placerer dem i listen af ordrer
    public void createOrderAndAddToList(Pizza pizzaToAdd, int waitTime, String nameOfPizza) {
        Order newOrder = new Order(pizzaToAdd, waitTime, nameOfPizza);
        placeOrderCorrectInList(newOrder);
    }

    // Placerer ordren i orderList i forhold til ventetiden til ventetiden (mindste ventetid bliver placeret øverst)
    public void placeOrderCorrectInList(Order newOrder) {
        if (orderList.size() >= 1) {
            for (int i = 0; i < orderList.size(); i++) {

                if (orderList.get(i).getWaitTime() == newOrder.getWaitTime()) {
                    // Tilføjer den nye ordre til OrderList på index i+1 = hvis ordren ved i og den nye ordre har samme ventetid
                    orderList.add(i + 1, newOrder);
                    break;

                } else if (orderList.get(i).getWaitTime() > newOrder.getWaitTime()) {
                    // Tilføjer den nye ordre til OrderList ved index i = første gang en ordres ventetid er højere end den nye ordres ventetid
                    orderList.add(i, newOrder);
                    break;
                } else if ((i + 1) == orderList.size() && orderList.get(i).getWaitTime() < newOrder.getWaitTime()) {
                    // Hvis OrderList sidste element stadig har en lavere ventetid end den nye ordre, bliver den bare tilføjet til listen
                    orderList.add(newOrder);
                    break;
                }
            }
        } else {
            // Hvis ordrelisten ikke har nogle ordrer bliver den nye ordrer bare placeret som første element
            orderList.add(newOrder);
        }
    }
}
