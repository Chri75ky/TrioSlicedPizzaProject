import java.util.ArrayList;

public class PizzaMenu {
    private ArrayList<Pizza> pizzaMenu = new ArrayList<>();

    public PizzaMenu() {
        //oprettelse af pizzaerne
        Pizza vesuvio = new Pizza("Vesuvio", "ingredients-", 57);
        Pizza amerikaner = new Pizza("Amerikaner", "ingredients-", 53);
        Pizza cacciatore = new Pizza("Cacciatore", "ingredients-", 57);
        Pizza carbona = new Pizza("Carbona", "ingredients-", 63);
        Pizza dennis = new Pizza("Dennis", "ingredients-", 65);
        Pizza bertil = new Pizza("Bertil", "ingredients-", 57);
        Pizza silvia = new Pizza("Silvia", "ingredients-", 61);
        Pizza victoria = new Pizza("Victoria", "ingredients-", 61);
        Pizza toronfo = new Pizza("Toronfo", "ingredients-", 61);
        Pizza capriciossa = new Pizza("Capriciossa", "ingredients-", 61);
        Pizza hawai = new Pizza("Hawai", "ingredients-", 61);
        Pizza leBlissola = new Pizza("Le Blissola", "ingredients-", 61);
        Pizza venezia = new Pizza("Venezia", "ingredients-", 61);
        Pizza mafia = new Pizza("Mafia", "ingredients-", 61);
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

        //oprettelse af ingredienser
        Ingredient kylling = new Ingredient("Kylling", Ingredient.Type.KØD);
        Ingredient bacon = new Ingredient("Bacon", Ingredient.Type.KØD);
        Ingredient cocktailpølser = new Ingredient("Cocktailpølser", Ingredient.Type.KØD);
        Ingredient oksefars = new Ingredient("Oksefars", Ingredient.Type.KØD);
        Ingredient kebab = new Ingredient("Kebab", Ingredient.Type.KØD);
        Ingredient pepperoni = new Ingredient("Pepperoni", Ingredient.Type.KØD);
        Ingredient rejer = new Ingredient("Rejer", Ingredient.Type.KØD);
        Ingredient skinke = new Ingredient("Skinke", Ingredient.Type.KØD);
        Ingredient ost = new Ingredient("Ost", Ingredient.Type.KØD);
        Ingredient gorgonzola = new Ingredient("Gorgonzola", Ingredient.Type.KØD);
        Ingredient sNd = new Ingredient("Salat & dressing", Ingredient.Type.KØD);
        Ingredient ananas = new Ingredient("Ananas", Ingredient.Type.GRØNT);
        Ingredient champignon = new Ingredient("Champignon", Ingredient.Type.GRØNT);
        Ingredient chili = new Ingredient("Chili", Ingredient.Type.GRØNT);
        Ingredient hvidløg = new Ingredient("Hvidløg", Ingredient.Type.GRØNT);
        Ingredient jalapenos = new Ingredient("Jalapeños", Ingredient.Type.GRØNT);
        Ingredient løg = new Ingredient("Løg", Ingredient.Type.GRØNT);
        Ingredient oliven = new Ingredient("Oliven", Ingredient.Type.GRØNT);
        Ingredient paprika = new Ingredient("Paprika", Ingredient.Type.GRØNT);
        Ingredient thousandIsland = new Ingredient("Thousand Island dressing", Ingredient.Type.DRESSING);
        Ingredient dressing = new Ingredient("Creme Fraiche dressing", Ingredient.Type.DRESSING);
        Ingredient bearnaise = new Ingredient("Bearnaise sauce", Ingredient.Type.DRESSING);
        Ingredient hvdr = new Ingredient("Hvidløgsdressing", Ingredient.Type.DRESSING);
    }

    //tilføjer pizza til menu Arraylist
    public void addPizza(Pizza pizza) {
        pizzaMenu.add(pizza);
    }

    //fjerner pizza fra menu Arraylist
    public void removePizza(Pizza pizza){
        pizzaMenu.remove(pizza);
    }
    public Pizza getPizza(String pizzaName){
        for (Pizza pizza : pizzaMenu) {
            if (pizza.getPizzaName().equalsIgnoreCase(pizzaName)) {
                return pizza;
            }
        }
        return null;
    }



}
