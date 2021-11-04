import java.util.ArrayList;

public class PizzaMenu {
    private final ArrayList<Pizza> pizzaMenu = new ArrayList<>();

    public PizzaMenu() {
        //oprettelse af ingredienser
        Ingredient kylling = new Ingredient("kylling", Ingredient.Type.KØD);
        Ingredient bacon = new Ingredient("bacon", Ingredient.Type.KØD);
        Ingredient kødsauce = new Ingredient("kødsauce", Ingredient.Type.KØD);
        Ingredient spaghetti = new Ingredient("spaghetti", Ingredient.Type.KØD);
        Ingredient cocktailpølser = new Ingredient("cocktailpølser", Ingredient.Type.KØD);
        Ingredient oksefars = new Ingredient("oksefars", Ingredient.Type.KØD);
        Ingredient kebab = new Ingredient("kebab", Ingredient.Type.KØD);
        Ingredient pepperoni = new Ingredient("pepperoni", Ingredient.Type.KØD);
        Ingredient rejer = new Ingredient("rejer", Ingredient.Type.KØD);
        Ingredient skinke = new Ingredient("skinke", Ingredient.Type.KØD);
        Ingredient ost = new Ingredient("ost", Ingredient.Type.KØD);
        Ingredient gorgonzola = new Ingredient("gorgonzola", Ingredient.Type.KØD);
        Ingredient sNd = new Ingredient("salat & dressing", Ingredient.Type.KØD);
        Ingredient ananas = new Ingredient("ananas", Ingredient.Type.GRØNT);
        Ingredient champignon = new Ingredient("champignon", Ingredient.Type.GRØNT);
        Ingredient chili = new Ingredient("chili", Ingredient.Type.ANDET);
        Ingredient hvidløg = new Ingredient("hvidløg", Ingredient.Type.ANDET);
        Ingredient oregano = new Ingredient("oregano", Ingredient.Type.ANDET);
        Ingredient jalapenos = new Ingredient("jalapeños", Ingredient.Type.GRØNT);
        Ingredient løg = new Ingredient("løg", Ingredient.Type.GRØNT);
        Ingredient oliven = new Ingredient("oliven", Ingredient.Type.GRØNT);
        Ingredient paprika = new Ingredient("rød peber", Ingredient.Type.GRØNT);
        Ingredient thousandIsland = new Ingredient("thousand Island dressing", Ingredient.Type.DRESSING);
        Ingredient dressing = new Ingredient("creme fraiche dressing", Ingredient.Type.DRESSING);
        Ingredient bearnaise = new Ingredient("bearnaise sauce", Ingredient.Type.DRESSING);
        Ingredient hvdr = new Ingredient("hvidløgsdressing", Ingredient.Type.DRESSING);
        Ingredient tomatsauce = new Ingredient("tomatsauce", Ingredient.Type.DRESSING);

        //oprettelse af pizzaerne
        Pizza vesuvio = new Pizza("Vesuvio", tomatsauce, ost, skinke, oregano, 57, 1);
        Pizza amerikaner = new Pizza("Amerikaner", tomatsauce, ost, oksefars, oregano, 53, 2);
        Pizza cacciatore = new Pizza("Cacciatore", tomatsauce, ost, pepperoni, oregano, 57, 3);
        Pizza carbona = new Pizza("Carbona", tomatsauce, ost, kødsauce, spaghetti, cocktailpølser, oregano, 63, 4);
        Pizza dennis = new Pizza("Dennis", tomatsauce, ost, skinke, pepperoni, cocktailpølser, oregano, 65, 5);
        Pizza bertil = new Pizza("Bertil", tomatsauce, ost, bacon, oregano, 57, 6);
        Pizza silvia = new Pizza("Silvia", tomatsauce, ost, pepperoni, paprika, løg, oliven, oregano, 61, 7);
        Pizza victoria = new Pizza("Victoria", tomatsauce, ost, skinke, ananas, champignon, løg, oregano, 61, 8);
        Pizza toronfo = new Pizza("Toronfo", tomatsauce, ost, skinke, bacon, kebab, chili, oregano, 61, 9);
        Pizza capriciossa = new Pizza("Capriciossa", tomatsauce, ost, skinke, champignon, oregano, 61, 10);
        Pizza hawai = new Pizza("Hawai", tomatsauce, ost, skinke, ananas, oregano, 61, 11);
        Pizza leBlissola = new Pizza("Le Blissola", tomatsauce, ost, skinke, rejer, oregano, 61, 12);
        Pizza venezia = new Pizza("Venezia", tomatsauce, ost, skinke, bacon, oregano, 61, 13);
        Pizza mafia = new Pizza("Mafia", tomatsauce, ost, pepperoni, bacon, løg, oregano, 61, 14);

        // Tilføjer alle pizzaer til pizzamenuen
        pizzaMenu.add(vesuvio);
        pizzaMenu.add(amerikaner);
        pizzaMenu.add(cacciatore);
        pizzaMenu.add(carbona);
        pizzaMenu.add(dennis);
        pizzaMenu.add(bertil);
        pizzaMenu.add(silvia);
        pizzaMenu.add(victoria);
        pizzaMenu.add(toronfo);
        pizzaMenu.add(capriciossa);
        pizzaMenu.add(hawai);
        pizzaMenu.add(leBlissola);
        pizzaMenu.add(venezia);
        pizzaMenu.add(mafia);
    }

    //tilføjer pizza til menu Arraylist
    public void addPizza(Pizza pizza) {
        pizzaMenu.add(pizza);
    }

    //fjerner pizza fra menu Arraylist
    public void removePizza(Pizza pizza) {
        pizzaMenu.remove(pizza);
    }


    public Pizza getPizza(int pizzaPlacement) {
        for (Pizza pizza : pizzaMenu) {
            if (pizza.getPlacement() == pizzaPlacement) {
                return pizza;
            }
        }
        return null;
    }


}
