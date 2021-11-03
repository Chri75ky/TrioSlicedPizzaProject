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
        orderList.add(newOrder);
    }
}
