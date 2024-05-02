import java.util.ArrayList;
import java.util.Scanner;

public class Airport {

    // using singelton
    private static Airport instance;

    private String name;
    private ArrayList<Airline> airlines;
    
    Scanner scanner = new Scanner(System.in);

    public static Airport getInstance(){
        if (instance == null){
            instance = new Airport();
        }

        return instance;
    }

    public Airline chooseAirlineByName() {
        // handle case there are no airlines
        if (airlines == null) {
            return null;
        }

        for (Airline airline: airlines) {
            System.out.println(airline.getName());
        }

        System.out.println("Enter your choice:");
        int currentChoice = scanner.nextInt() - 1;
        Airline chosen = airlines.get(currentChoice);
        return chosen;
    }





    public void searchFlightsOptions() {

    }





    public void watchAndManageAirlineOptions(){
        System.out.println("What would you like to do:");

        System.out.println("1. Watch airline data");
        System.out.println("2. Manage airline data");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        Airline chosenAirline = chooseAirlineByName();

        if (chosenAirline == null) {
            System.out.println("There are no airlines available");
            return;
        }

        switch (choice) {
            case 1:
                watchAirline(chosenAirline);
                break;

            case 2:

                break;

            default:
                System.out.println("Invalid choice!");
        }


    }

    public void watchAirline(Airline chosenAirline) {
        System.out.println("What would you like to do:");

        System.out.println("1. Watch flights");
        System.out.println("2. Watch staff");
        System.out.println("2. Watch sub airlines");


        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 


        switch (choice) {
            case 1:
                chosenAirline.printFlights();
                break;

            case 2:
                chosenAirline.printStaff();
                break;

            default:
                System.out.println("Invalid choice!");
        }


    }

    
}
