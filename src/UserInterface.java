import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Controller con = new Controller();

    // Skaber run metoden, som skal modtage input fra bruger og derefter sende videre til Controller.
    public void run() throws FileNotFoundException {
        boolean run = true;
        Scanner in = new Scanner(System.in);

        while (run) {
            System.out.println("""
                                    
                    Velkommen til Marios Pizza, hvad ønsker de at gøre:
                                            
                    1) Oprette en ordre
                    2) Færdiggøre en ordre
                    3) Se bestillingsoversigt
                    4) Se menukort
                                            
                    0) Luk programmet
                    """);

            String userInput = in.nextLine();
            // Modtager bruger input og finder den korrekte metode
            switch (userInput) {
                case "1":
                    System.out.println("Du har valgt at oprette en ordre");
                    createOrder();
                    break;

                case "2":
                    System.out.println("Du har valgt at færdiggøre en eksisterende ordre");
                    finishOrder();
                    break;

                case "3":
                    System.out.println("Du har valgt at se din eksisterende bestillingsoversigt");
                    System.out.println(showOrderListInString());
                    break;

                case "4":
                    System.out.println("\t\t\t\t\t\t\t\t\tMenukort");
                    showMenu();
                    break;

                case "0":
                    System.out.println("Lukker programmet....");
                    exit();
                    break;
            }
        }
    }

    // Melder en specifik ordrer som "Afsluttet"
    private void finishOrder() throws FileNotFoundException {
        if (con.showOrderList().size() > 0) {
            System.out.println("Her er de nuværende ordrer i systemet: ");
            System.out.println(showOrderListInString());
            Scanner input = new Scanner(System.in);
            System.out.println("Skriv nummeret på ordren som skal afsluttes: ");
            int ordreNr = input.nextInt() - 1;

            if (con.showOrderList().size() >= ordreNr+1) {
                con.finishOrder(ordreNr);
            } else {
                System.out.println("Ordre nummeret er ugyldigt.");
            }
        } else {
            System.out.println("Der er ingen ordre på listen.");
        }
    }


    // Viser en liste af ordrer
    private ArrayList<Order> showOrderList() {
        return con.showOrderList();
    }

    //returnere en liste af ordrer ud fra stringBuilder
    private String showOrderListInString() {
        return con.showOrderListInString();
    }

    // Gemmer ordrelisten til en fil før systemet lukker
    private void exit() {
    }

    // Skaber en ordre, som skal kunne tilføjes til klassen OrderList's ArrayListe
    private void createOrder() {
        Scanner input = new Scanner(System.in);

        System.out.println("For at kunne oprette din ordrer, skal vi bruge nogle informationer: ");
        System.out.println("Nummeret på din pizza: ");
        int pizzaPlacement = input.nextInt();
        // Tjekker hvorvidt det pizza navn brugeren indtaster findes i menuen og tilføjer pizzaen til listen af ordre.
        if (con.findPizza(pizzaPlacement)) {
            System.out.println("Hvor mange minutter vil det tage før pizzaen kan afhentes?");
            int minutesTillPickup = input.nextInt();
            con.addToOrderList(pizzaPlacement, minutesTillPickup);
            System.out.println("Ordren er blevet tilføjet til listen af ordre!");
            System.out.println("Ønsker du at se listen? (J/N)");
            input.nextLine();
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("j")) {
                System.out.println(showOrderListInString());
            }
        } else {
            System.out.println("Denne pizza eksisterer ikke i vores menu!");
            //TODO tilføj en metode til at skabe en custom pizza
            System.out.println("""
                    Skab din egen pizza
                    -------------------
                    Indtast venligst de ingredienser der skal være på den nye pizza""");
            System.out.print("Ingredienser: ");
            String ingredienser = input.nextLine();
        }
    }

    // Viser menukortet
    private void showMenu() throws FileNotFoundException {
        StringBuilder menu = con.showMenu();
        System.out.print(menu);
    }
}
