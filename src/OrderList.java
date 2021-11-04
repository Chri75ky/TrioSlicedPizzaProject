import java.util.ArrayList;

public class OrderList {
    private final Order order;
    private final ArrayList<Order> orderList = new ArrayList<>();

    public OrderList() {
        order = new Order();
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void addToOrderList(Order order) {
        orderList.add(order);
    }

    public void createOrderAndAddToList(Pizza pizzaToAdd, int waitTime, String orderName) {
        Order newOrder = new Order(pizzaToAdd, waitTime, orderName);
        placeOrderCorrectInList(newOrder);
    }


    //Places order in orderList corresponding to waitTime (lowest wait time will be placed first)
    public void placeOrderCorrectInList(Order newOrder) {
        if (orderList.size() >= 1) {
            for (int i = 0; i < orderList.size(); i++) {

                if (orderList.get(i).getWaitTime() > newOrder.getWaitTime()) {
                    // Adds newOrder to orderList at index i = first time a order elements waittime is higher than newOrders waittime
                    orderList.add(i, newOrder);
                    break;
                } else if ((i+1) == orderList.size() && orderList.get(i).getWaitTime() < newOrder.getWaitTime()) {
                    // If orderLists last element still has a lower waittime than newOrder, then newOrder will just be added to orderList
                    orderList.add(newOrder);
                }
            }
        } else {
            // If orderList has no objects a newOrder will just be placed as the first element
            orderList.add(newOrder);
        }
    }
}
