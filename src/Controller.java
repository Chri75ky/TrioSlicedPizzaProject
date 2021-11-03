import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private Order order;
    private final PizzaMenu pm;
    private final OrderList orderList;

    public Controller() {
        // Opretter pizzaMenu og OrderList objekter sådan at controlleren kan give og modtage information
        // vedrørende hvilke pizzaer der er og hvilke ordrer der er i gang
        pm = new PizzaMenu();
        orderList = new OrderList();
    }

    // Tjekker menuen for pizza med navn indtastet af bruger
    public boolean findPizza(String pizzaName) {
        boolean isPizzaInMenu = false;
        if (pm.getPizza(pizzaName) != null) {
            isPizzaInMenu = true;
        } else {
            return isPizzaInMenu;
        }
        return isPizzaInMenu;
    }

    // Returnerer en pizza med samme navn som det indtastet af bruger, er ikke
    // sikker på hvornår den skal bruges da den bruges i addToOrderList
    // men beholder den indtil videre :D
    public Pizza getPizza(String pizzaName) {
        return pm.getPizza(pizzaName);
    }

    // Tager i mod et navn og estimeret ventetid fra bruger og skaber en ordre med de informationer
    public void addToOrderList(String pizzaName, int waitTime) {
        Pizza pizzaToAdd = pm.getPizza(pizzaName);
        orderList.createOrderAndAddToList(pizzaToAdd, waitTime, pizzaName);
    }


    public void finishOrder() {
        // Meld en ordre som afsluttet

        // TODO Gem den afsluttede ordre til en fil ude fra systemet
    }

    // Viser den nuværende liste af ordre til brugeren
    public ArrayList<Order> showOrderList() {
        return orderList.getOrderList();
        // Henter en liste af ordrer fra OrderList
    }

    // Metoden opretter StringBuilder objekt som returnere stringBuilder med alle linjerne i 'PizzaMenuCard.txt" filen
    public StringBuilder showMenu() throws FileNotFoundException {
        Scanner menu = new Scanner(new File("PizzaMenuCard.txt"));
        StringBuilder fullMenu = new StringBuilder();

        while (menu.hasNextLine()) {
            fullMenu.append(menu.nextLine() + "\n");
        }
        return fullMenu;
    }
}
