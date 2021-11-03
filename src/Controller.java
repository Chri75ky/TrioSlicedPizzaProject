import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private Order order;
    private PizzaMenu pm;
    private OrderList orderList;
    private int orderID;

    public Controller() {
        pm = new PizzaMenu();
        orderList = new OrderList();
    }
    public boolean findPizza(String pizzaName) {
        boolean isPizzaInMenu = false;
        if (pm.getPizza(pizzaName) != null) {
            isPizzaInMenu = true;
        } else {
            return isPizzaInMenu;
        }
        return isPizzaInMenu;
    }
    public Pizza getPizza(String pizzaName){
        return pm.getPizza(pizzaName);
    }

    public void addToOrderList(String pizzaName, int waitTime) {
        Pizza pizzaToAdd = pm.getPizza(pizzaName);
        orderList.createOrderAndAddToList(pizzaToAdd, waitTime, pizzaName);
        System.out.println("LOL");
    }


    public void finishOrder(int ordreNr) throws FileNotFoundException {
        File file = new File("ordreHistorik.txt");
        PrintStream ps = new PrintStream(new FileOutputStream(file, true));
        orderID++;

        //Adds order to "ordreHistorik.txt"
        //TODO skal nok laves lidt om hvis der er flere pizzaer i samme ordre - evt "for loop"
        ps.append(orderID + "\t" + showOrderList().get(ordreNr).getOrderedPizza().getPizzaName() + "\t\t\t" + showOrderList().get(ordreNr).getOrderedPizza().getPrice() + " DKK" + "\n");

        //Removes order at [ordreNr] from orderList
        showOrderList().remove(ordreNr);


        // TODO Gem den afsluttede ordre til en fil ude fra systemet
    }

    public ArrayList<Order> showOrderList() {
        return orderList.getOrderList();
        // Henter en liste af ordrer fra OrderList
    }

    // Metoden opretter StringBuilder objekt som retunere stringbuilder med alle linjerne i 'PizzaMenuCard.txt" filen
    public StringBuilder showMenu() throws FileNotFoundException {
        Scanner menu = new Scanner(new File("PizzaMenuCard.txt"));
        StringBuilder fullMenu = new StringBuilder();

        while (menu.hasNextLine()) {
            fullMenu.append(menu.nextLine() + "\n");
        }
        return fullMenu;
    }
}
