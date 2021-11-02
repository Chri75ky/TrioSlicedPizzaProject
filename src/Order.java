import java.util.ArrayList;
// TODO Gør det muligt at tilføje flere pizzaer til en enkelt ordre
public class Order {
private ArrayList<Pizza> orderedPizza = new ArrayList<>();
private int waitTime;
public Order(Pizza pizza, int waitTime){
    orderedPizza.add(pizza);
    this.waitTime = waitTime;
}
    public boolean createOrder(String pizzaName){

        return true;
    }

    public ArrayList<Pizza> getOrderedPizza() {
        return orderedPizza;
    }

    public int getWaitTime() {
        return waitTime;
    }

    @Override
    public String toString() {
        return "Ordren består af " + orderedPizza + " med en ventetid til afhentning på: " + waitTime + " minutter.";
    }
}
