import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
    private Order order;
    private PizzaMenu pm;

    public Controller() {
        order = new Order();
        pm = new PizzaMenu();
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

    public void addToOrderList(String pizzaName) {
        System.out.println("LOL");
        //order.createOrder(pizzaName);
    }

    public void finishOrder() {
        // Meld en ordre som afsluttet

        // TODO Gem den afsluttede ordre til en fil ude fra systemet
    }

    public void showOrderList() {
        // Henter en liste af ordrer fra OrderList
    }

    public StringBuilder showMenu() throws FileNotFoundException {
        Scanner menu = new Scanner(new File("PizzaMenuCard.txt"));
        StringBuilder fullMenu = new StringBuilder();

        while (menu.hasNextLine()) {
            fullMenu.append(menu.nextLine() + "\n");
        }
        return fullMenu;
    }
}
