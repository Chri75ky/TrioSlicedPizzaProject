import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private final PizzaMenu pm;
    private final OrderList orderList;

    public Controller() {
        // Opretter pizzaMenu og OrderList objekter sådan at controlleren kan give og modtage information
        // vedrørende hvilke pizzaer der er og hvilke ordrer der er i gang
        pm = new PizzaMenu();
        orderList = new OrderList();
    }

    // Tjekker menuen for pizza med navn indtastet af bruger
    public boolean findPizza(int pizzaPlacement) {
        boolean isPizzaInMenu = false;
        if (pm.getPizza(pizzaPlacement) != null) {
            isPizzaInMenu = true;
        } else {
            return isPizzaInMenu;
        }
        return isPizzaInMenu;
    }

    // Tager i mod en position af en pizza og estimeret ventetid fra bruger
    // og skaber en ordre med de informationer
    public void addToOrderList(int pizzaPlacement, int waitTime) {
        Pizza pizzaToAdd = pm.getPizza(pizzaPlacement);
        String nameOfPizza = pizzaToAdd.getPizzaName();
        orderList.createOrderAndAddToList(pizzaToAdd, waitTime, nameOfPizza);
    }

    // Fjerner en ordre og tilføjer den til fil udenfor programmet
    public void finishOrder(int ordreNr, File file) throws FileNotFoundException {
        PrintStream ps = new PrintStream(new FileOutputStream(file, true));
        Scanner out = new Scanner(file);
        int orderID = 1;


        while (out.hasNextLine()) {
            orderID++;
            out.nextLine();
        }

        // Tilføjer ordre til "ordreHistorik.txt"
        ps.append(orderID + "\t" + showOrderList().get(ordreNr).getOrderedPizza().getPizzaName() + "\t\t\t" + showOrderList().get(ordreNr).getOrderedPizza().getPrice() + " DKK" + "\n");

        // Fjerner ordre af [ordreNr] fra orderList
        showOrderList().remove(ordreNr);
    }


    // Viser den nuværende liste af ordre til brugeren
    public ArrayList<Order> showOrderList() {
        return orderList.getOrderList();
        // Henter en liste af ordrer fra OrderList
    }


    // Skaber en stringBuilder som paster listen ud som String
    public String showOrderListInString() {
        ArrayList<Order> orderList = this.orderList.getOrderList();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < orderList.size(); i++) {
            str.append((i + 1) + ")\t");
            str.append(Colour.TEXT_YELLOW + "Pizza: " + Colour.TEXT_RESET + Colour.TEXT_GREEN + orderList.get(i).getOrderedPizza().getPizzaName() + Colour.TEXT_RESET + "\t\t");
            str.append(Colour.TEXT_YELLOW + "Ventetid: " + Colour.TEXT_RESET + Colour.TEXT_GREEN + orderList.get(i).getWaitTime() + Colour.TEXT_RESET + "\n");
        }

        String showOrderList = str.toString();
        return showOrderList;
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
