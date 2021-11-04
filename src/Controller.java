import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
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
    public boolean findPizza(int pizzaPlacement) {
        boolean isPizzaInMenu = false;
        if (pm.getPizza(pizzaPlacement) != null) {
            isPizzaInMenu = true;
        } else {
            return isPizzaInMenu;
        }
        return isPizzaInMenu;
    }

    // Returnerer en pizza med samme navn som det indtastet af bruger, er ikke
    // sikker på hvornår den skal bruges da den bruges i addToOrderList
    // men beholder den indtil videre :D
    public Pizza getPizza(int pizzaPlacement) {
        return pm.getPizza(pizzaPlacement);
    }

    // Tager i mod et navn og estimeret ventetid fra bruger og skaber en ordre med de informationer
    public void addToOrderList(int pizzaPlacement, int waitTime) {
        Pizza pizzaToAdd = pm.getPizza(pizzaPlacement);
        String nameOfPizza = pizzaToAdd.getPizzaName();
        orderList.createOrderAndAddToList(pizzaToAdd, waitTime, nameOfPizza);
    }


    public void finishOrder(int ordreNr, File file) throws FileNotFoundException {
        PrintStream ps = new PrintStream(new FileOutputStream(file, true));
        Scanner out = new Scanner(file);
        int orderID = 1;


        while (out.hasNextLine()) {
            orderID++;
            out.nextLine();
        }

        //Adds order to "ordreHistorik.txt"
        //TODO skal nok laves lidt om hvis der er flere pizzaer i samme ordre - evt "for loop"
        ps.append(orderID + "\t" + showOrderList().get(ordreNr).getOrderedPizza().getPizzaName() + "\t\t\t" + showOrderList().get(ordreNr).getOrderedPizza().getPrice() + " DKK" + "\n");

        //Removes order at [ordreNr] from orderList
        showOrderList().remove(ordreNr);
    }


    // Viser den nuværende liste af ordre til brugeren
    public ArrayList<Order> showOrderList() {
        return orderList.getOrderList();
        // Henter en liste af ordrer fra OrderList
    }


    // Methods creates stringbuilder over the orderList and returns a string with it. //TODO skal også ændres lidt hvis flere pizzaer kan bestilles i samme ordre
    public String showOrderListInString() {
        ArrayList<Order> orderList = this.orderList.getOrderList();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < orderList.size(); i++) {
            str.append((i+1) + ")\t");
            str.append("Pizza: " + orderList.get(i).getOrderedPizza().getPizzaName() + "\t\t");
            str.append("Wait time: " + orderList.get(i).getWaitTime() + "\n");
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
