import java.util.Scanner;

public class UserInterface {
    Controller con = new Controller();
    public void run(){
        boolean run = true;

        Scanner in = new Scanner(System.in);

        while(run) {
            System.out.println("""
                                    
                    Velkommen til Marios Pizza, hvad ønsker de at gøre:
                                            
                    1) Oprette en ordre
                    2) Færdiggøre en ordre
                    3) Se bestillingsoversigt
                                            
                    0) Luk programmet
                    """);

            String userInput = in.nextLine();

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
                    showOrderList();
                    break;

                case "0":
                    System.out.println("Lukker programmet....");
                    exit();
                    break;
            }
        }
    }

    private void finishOrder() {
    }

    private void showOrderList() {
    }

    private void exit() {
    }

    private void createOrder() {
        Scanner input = new Scanner(System.in);

        System.out.println("For at kunne oprette din ordrer, skal vi bruge nogle informationer: ");
        System.out.println("Navnet på din pizza: ");
        String pizzaName = input.nextLine();
        if(con.findPizza(pizzaName)){
            con.addToOrderList(pizzaName);

        }
    }
}
