import java.util.ArrayList;

public class OrderList {
    private ArrayList<Order> orderList = new ArrayList<>();

    public ArrayList<Order> getOrderList() {
        return orderList;
    }
    public void addToOrderList(Order order){
        orderList.add(order);
    }
}
