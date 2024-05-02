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

    public void addMockData() {
        airlines = new ArrayList<>();

        // Creating airline 1 with mock flights and crew members
        Airline airline1 = new Airline("Airline A", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Flight flight1 = new Flight(101, 200, 900, 1200, 3, 300, airline1, new ArrayList<>(), null);
        Flight flight2 = new Flight(102, 250, 1100, 1400, 3, 300, airline1, new ArrayList<>(), null);
        airline1.addFlight(flight1);
        airline1.addFlight(flight2);
        airline1.addStaff(new CrewMember(1, "John", "Doe", airline1, 101, 5000));
        airline1.addStaff(new CrewMember(2, "Jane", "Smith", airline1, 102, 5500));
        airlines.add(airline1);

        // Creating airline 2 with mock flights and crew members
        Airline airline2 = new Airline("Airline B", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Flight flight3 = new Flight(103, 180, 800, 1100, 2, 200, airline2, new ArrayList<>(), null);
        Flight flight4 = new Flight(104, 220, 1000, 1300, 2, 200, airline2, new ArrayList<>(), null);
        airline2.addFlight(flight3);
        airline2.addFlight(flight4);
        airline2.addStaff(new CrewMember(3, "Michael", "Johnson", airline2, 103, 4800));
        airline2.addStaff(new CrewMember(4, "Emily", "Williams", airline2, 104, 5200));
        airlines.add(airline2);

        // Creating airline 3 with mock flights and crew members
        Airline airline3 = new Airline("Airline C", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Flight flight5 = new Flight(105, 300, 1200, 1500, 4, 400, airline3, new ArrayList<>(), null);
        Flight flight6 = new Flight(106, 280, 1300, 1600, 4, 400, airline3, new ArrayList<>(), null);
        airline3.addFlight(flight5);
        airline3.addFlight(flight6);
        airline3.addStaff(new CrewMember(5, "David", "Brown", airline3, 105, 4900));
        airline3.addStaff(new CrewMember(6, "Sarah", "Jones", airline3, 106, 5300));
        airlines.add(airline3);
    }

    public Airline chooseAirlineByName() {
        // handle case there are no airlines
        if (airlines == null) {
            System.out.println("There are no airlines available");

            return null;
        }

        System.out.println("Choose airline:");

        for (int i = 0; i < airlines.size(); i ++) {
            System.out.println(i+1 + ". " + airlines.get(i).getName());
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
