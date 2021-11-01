public class Pizza {
    private String pizzaName;
    private int price;
    private String ingredients;

    public Pizza(String pizzaName, String ingredients, int price) {
        this.pizzaName = pizzaName;
        this.ingredients = ingredients;
        this.price = price;
    }

    @Override
    public String toString() {
        return pizzaName + ": " + ingredients + "............................." + price + ",-";
    }
}
