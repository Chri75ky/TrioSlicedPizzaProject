import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class UserInterface {
    Controller con = new Controller();

    // Skaber run metoden, som skal modtage input fra bruger og derefter sende videre til Controller.
    public void run() throws FileNotFoundException {
        boolean run = true;
        Scanner in = new Scanner(System.in);
        File file = new File("ordreHistorik.txt");

        while (run) {
            System.out.println(Colour.TEXT_YELLOW + """
                                    
                    Velkommen til Marios Pizza, hvad ønsker de at gøre:
                                            
                    1) Oprette en ordre
                    2) Færdiggøre en ordre
                    3) Se bestillingsoversigt
                    4) Se menukort
                    5) Slet ordre historik
                                            
                    0) Luk programmet
                    """ + Colour.TEXT_RESET);

            String userInput = in.nextLine();
            // Modtager bruger input og finder den korrekte metode
            switch (userInput) {
                case "1":
                    System.out.println(Colour.TEXT_GREEN + "Du har valgt at oprette en ordre" + Colour.TEXT_RESET);
                    createOrder();
                    break;

                case "2":
                    System.out.println(Colour.TEXT_GREEN + "Du har valgt at færdiggøre en eksisterende ordre" + Colour.TEXT_RESET);
                    finishOrder(file);
                    break;

                case "3":
                    System.out.println(Colour.TEXT_GREEN + "Du har valgt at se din eksisterende bestillingsoversigt" + Colour.TEXT_RESET);
                    System.out.println(showOrderListInString());
                    break;

                case "4":
                    System.out.println(Colour.TEXT_GREEN + "\t\t\t\t\t\t\t\t\tMenukort" + Colour.TEXT_RESET);
                    showMenu();
                    break;

                case "5":
                    System.out.println(Colour.TEXT_GREEN + "Sletter ordre historik..." + Colour.TEXT_RESET);
                    deleteOrderHistorik(file);
                    System.out.println(Colour.TEXT_RED + "Ordre historikken er slettet" + Colour.TEXT_RESET);
                    break;

                case "0":
                    System.out.println(Colour.TEXT_RED + "Lukker programmet...." + Colour.TEXT_RESET);
                    exit();
                    break;
            }
        }
    }

    // Melder en specifik ordrer som "Afsluttet"
    private void finishOrder(File file) throws FileNotFoundException {
        if (con.showOrderList().size() > 0) {
            System.out.println(Colour.TEXT_YELLOW + "Her er de nuværende ordrer i systemet: " + Colour.TEXT_RESET);
            System.out.println(showOrderListInString());
            Scanner input = new Scanner(System.in);
            System.out.println(Colour.TEXT_RED + "Skriv nummeret på ordren som skal afsluttes: " + Colour.TEXT_RESET);
            int ordreNr = input.nextInt() - 1;

            if (con.showOrderList().size() >= ordreNr + 1) {
                con.finishOrder(ordreNr, file);
            } else {
                System.out.println(Colour.TEXT_RED + "Ordre nummeret er ugyldigt." + Colour.TEXT_RESET);
            }
        } else {
            System.out.println(Colour.TEXT_RED + "Der er ingen ordre på listen." + Colour.TEXT_RESET);
        }
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

        System.out.println(Colour.TEXT_YELLOW + "For at kunne oprette din ordrer, skal vi bruge nogle informationer: " + Colour.TEXT_RESET);
        System.out.println(Colour.TEXT_RED + "Nummeret på din pizza: " + Colour.TEXT_RESET);
        int pizzaPlacement = input.nextInt();
        // Tjekker hvorvidt det pizza navn brugeren indtaster findes i menuen og tilføjer pizzaen til listen af ordre.
        if (con.findPizza(pizzaPlacement)) {
            System.out.println(Colour.TEXT_RED + "Hvor mange minutter vil det tage før pizzaen kan afhentes?" + Colour.TEXT_RESET);
            int waitTime = input.nextInt();
            // Tilføjer den ønskede pizza til ordrelisten med den estimerede ventetid.
            con.addToOrderList(pizzaPlacement, waitTime);
            System.out.println(Colour.TEXT_YELLOW + "Ordren er blevet tilføjet til listen af ordre!");
            System.out.println("Ønsker du at se listen? (J/N)" + Colour.TEXT_RESET);
            input.nextLine();
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("j")) {
                System.out.println(showOrderListInString());
            } else {
                System.out.println(Colour.TEXT_RED + "Returnerer til hovedmenuen..." + Colour.TEXT_RESET);
            }
        } else {
            System.out.println(Colour.TEXT_RED + "Denne pizza eksisterer ikke i vores menu!" + Colour.TEXT_RESET);
        }
    }

    // Viser menukortet
    private void showMenu() throws FileNotFoundException {
        StringBuilder menu = con.showMenu();
        System.out.print(menu);
    }

    private void deleteOrderHistorik(File file) throws FileNotFoundException {
        new PrintStream(file).close();
    }
}
