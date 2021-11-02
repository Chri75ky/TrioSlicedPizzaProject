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
