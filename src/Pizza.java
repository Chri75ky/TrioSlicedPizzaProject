public class Pizza {
    private final String pizzaName;
    private final int price;
    private final int placement;
    Ingredient ingredient;
    Ingredient ingredient1;
    Ingredient ingredient2;
    Ingredient ingredient3;
    Ingredient ingredient4;
    Ingredient ingredient5;
    Ingredient ingredient6;

    // Skaber flere konstruktører,
    // sådan at forskellige pizzaer kan oprettes med et forskelligt antal ingredienser.
    public Pizza(String pizzaName, Ingredient ingredient, Ingredient ingredient1, Ingredient ingredient2, Ingredient ingredient3, int price, int placement) {
        this.pizzaName = pizzaName;
        this.ingredient = ingredient;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.price = price;
        this.placement = placement;
    }

    public Pizza(String pizzaName, Ingredient ingredient, Ingredient ingredient1, Ingredient ingredient2, Ingredient ingredient3, Ingredient ingredient4, Ingredient ingredient5, int price, int placement) {
        this.pizzaName = pizzaName;
        this.ingredient = ingredient;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
        this.ingredient5 = ingredient5;
        this.price = price;
        this.placement = placement;
    }

    public Pizza(String pizzaName, Ingredient ingredient, Ingredient ingredient1, Ingredient ingredient2, Ingredient ingredient3, Ingredient ingredient4, Ingredient ingredient5, Ingredient ingredient6, int price, int placement) {
        this.pizzaName = pizzaName;
        this.ingredient = ingredient;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
        this.ingredient5 = ingredient5;
        this.ingredient6 = ingredient6;
        this.price = price;
        this.placement = placement;
    }

    public Pizza(String pizzaName, Ingredient ingredient, Ingredient ingredient1, Ingredient ingredient2, Ingredient ingredient3, Ingredient ingredient4, int price, int placement) {
        this.pizzaName = pizzaName;
        this.ingredient = ingredient;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
        this.price = price;
        this.placement = placement;
    }

    @Override
    public String toString() {
        return pizzaName;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public int getPlacement() {
        return placement;
    }

    public int getPrice() {
        return price;
    }


}
