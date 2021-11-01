public class Controller {

    Order order = new Order();

    public boolean findPizza(String pizzaName) {
        return false;
    }

    public void addToOrderList(String pizzaName) {
        order.createOrder(pizzaName);
    }
}
