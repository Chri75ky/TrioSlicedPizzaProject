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
    }

    //tilføjer pizza til menu Arraylist
    public void addPizza(Pizza pizza) {
        pizzaMenu.add(pizza);
    }

    //fjerner pizza fra menu Arraylist
    public void removePizza(Pizza pizza){
        pizzaMenu.remove(pizza);
    }



}
