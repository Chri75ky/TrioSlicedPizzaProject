// TODO Gør det muligt at tilføje flere pizzaer til en enkelt ordre
public class Order {
    // Ordrer
    private Pizza orderedPizza;
    private int waitTime;
    private String orderName;

    public Order(Pizza pizza, int waitTime, String orderName) {
        orderedPizza = pizza;
        this.waitTime = waitTime;
        this.orderName = orderName;
    }

    public Order() {
    }

    public Pizza getOrderedPizza() {
        return orderedPizza;
    }

    public int getWaitTime() {
        return waitTime;
    }

    @Override
    public String toString() {
        return "Ordren består af pizzaen '" + orderedPizza + "' med en ventetid til afhentning på: " + waitTime + " minutter.";
    }
}
