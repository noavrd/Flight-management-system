import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Airport
        Airport airport = new Airport();
        // Add mock data to the airport
        airport.addMockData();
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
       
            System.out.println("Welcome to flight management system! ");
          
            System.out.println("What would you like to do?");

            // Display menu options
            System.out.println("1. Search a flight");
            System.out.println("2. Watch and manage airlines");
            System.out.println("3. Sign in as observer");
            System.out.println("4. unsubscribe as observer");
            System.out.println("5. Create notification");
            System.out.println("6. Show my notifications");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    airport.searchFlightsOptions();
                    break;

                case 2:
                    airport.watchAndManageAirlineOptions();
                    break;

                case 3:
                    airport.signInAsObserver();
                    main(args);
                    break;

                
                case 4:
                    airport.unsubscribeAsObserver();
                    main(args);
                    break;

                case 5:
                    airport.createNotification();
                    main(args);
                    break;

                case 6:
                    airport.choosePersonToShow();
                    main(args);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            exit = true;

        }

        scanner.close();
    }
}
