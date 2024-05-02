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

   // Mock data method to initialize airlines, flights, crew members, and passengers
    public void addMockData() {
        airlines = new ArrayList<>();

        // Creating airline 1 with mock flights and crew members
        Airline airline1 = new Airline("Airline A", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Flight flight1 = new Flight(101, 200, 900, 1200, 3, airline1, new ArrayList<>(), null);
        Flight flight2 = new Flight(102, 250, 1100, 1400, 3, airline1, new ArrayList<>(), null);
        airline1.addFlight(flight1);
        airline1.addFlight(flight2);
        airline1.addStaff(new CrewMember(1, "John", "Doe", airline1, 101, 5000));
        airline1.addStaff(new CrewMember(2, "Jane", "Smith", airline1, 102, 5500));
        airlines.add(airline1);

        // Add passengers to flights of airline 1
        flight1.addPassenger(new Passenger(201, "Alice", "Johnson", 123456789));
        flight1.addPassenger(new Passenger(202, "Bob", "Smith", 987654321));
        flight2.addPassenger(new Passenger(203, "Eva", "Brown", 456789123));
        flight2.addPassenger(new Passenger(204, "Michael", "Williams", 987123456));

        // Creating airline 2 with mock flights and crew members
        Airline airline2 = new Airline("Airline B", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Flight flight3 = new Flight(103, 20000, 800, 1100, 2, airline2, new ArrayList<>(), null);
        Flight flight4 = new Flight(104, 40000, 1000, 1300, 2, airline2, new ArrayList<>(), null);
        airline2.addFlight(flight3);
        airline2.addFlight(flight4);
        airline2.addStaff(new CrewMember(3, "Michael", "Johnson", airline2, 103, 4800));
        airline2.addStaff(new CrewMember(4, "Emily", "Williams", airline2, 104, 5200));
        airlines.add(airline2);

        // Add passengers to flights of airline 2
        flight3.addPassenger(new Passenger(205, "Sophia", "Jones", 789456123));
        flight3.addPassenger(new Passenger(206, "David", "Brown", 654789123));
        flight4.addPassenger(new Passenger(207, "Emma", "Anderson", 951753852));
        flight4.addPassenger(new Passenger(208, "Daniel", "Garcia", 369852147));

        // Creating airline 3 with mock flights and crew members
        Airline airline3 = new Airline("Airline C", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Flight flight5 = new Flight(105, 300, 1200, 1500, 4, airline3, new ArrayList<>(), null);
        Flight flight6 = new Flight(106, 280, 1300, 1600, 4, airline3, new ArrayList<>(), null);
        airline3.addFlight(flight5);
        airline3.addFlight(flight6);
        airline3.addStaff(new CrewMember(5, "David", "Brown", airline3, 105, 4900));
        airline3.addStaff(new CrewMember(6, "Sarah", "Jones", airline3, 106, 5300));
        airlines.add(airline3);

        // Add passengers to flights of airline 3
        flight5.addPassenger(new Passenger(209, "Olivia", "Taylor", 147258369));
        flight5.addPassenger(new Passenger(210, "William", "Martinez", 369147258));
        flight6.addPassenger(new Passenger(211, "Ava", "Robinson", 258369147));
        flight6.addPassenger(new Passenger(212, "James", "Lee", 963852741));
    }


    public Airline chooseAirlineByName(ArrayList<Airline> airlinesToChoose) {
        // handle case there are no airlines
        if (airlinesToChoose == null) {
            System.out.println("There are no airlines available");

            return null;
        }

        System.out.println("Choose airline:");

        for (int i = 0; i < airlinesToChoose.size(); i ++) {
            System.out.println(i+1 + ". " + airlinesToChoose.get(i).getName());
        }

        System.out.println("Enter your choice:");
        int currentChoice = scanner.nextInt() - 1;
        Airline chosen = airlinesToChoose.get(currentChoice);
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

     
        switch (choice) {
            case 1:
                Airline chosenAirline = chooseAirlineByName(airlines);
                if (chosenAirline == null) {
                    System.out.println("There are no airlines available");
                    break;
                }
                watchAirline(chosenAirline);
                watchAndManageAirlineOptions();
                break;

            case 2:
                Airline chosen = chooseAirlineByName(airlines);
                if (chosen == null) {
                    System.out.println("There are no airlines available");
                    break;
                }
                manageAirline(chosen);
                watchAndManageAirlineOptions();            
                break;

            default:
                System.out.println("Invalid choice! Try again");
                watchAndManageAirlineOptions();
        }


    }

    public void watchAirline(Airline chosenAirline) {
        System.out.println("What would you like to do:");

        System.out.println("1. Watch flights");
        System.out.println("2. Watch staff");
        System.out.println("3. Watch sub airlines");
        System.out.println("4. Watch other data");



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

            case 3:
                chosenAirline.printSubAirlines();
                break;

            case 4:
                System.out.println("Total flights: " + chosenAirline.totalFlights());
                System.out.println("Total profits: " + chosenAirline.totalProfits());
                System.out.println("Total passengers: " + chosenAirline.totalPassengers());

                break;
            default:
                System.out.println("Invalid choice! Try again");
                watchAirline(chosenAirline);
        }


    }

    public void manageAirline(Airline chosenAirline) {
        System.out.println("What would you like to do:");

        System.out.println("1. Add flight");
        System.out.println("2. Cancel flight");
        System.out.println("3. Add staff member");
        System.out.println("4. Remove staff member");
        System.out.println("5. Manage sub airlines");



        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 


        switch (choice) {
            case 1:
                System.out.print("Enter Flight number: ");
                int flightNum = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Enter price: ");
                int price = scanner.nextInt();
                System.out.print("Enter departure time: ");
                int departureTime = scanner.nextInt();
                System.out.print("Enter arrival time: ");
                int arrivalTime = scanner.nextInt();
                System.out.print("Enter flight duration: ");
                int flightDuration = scanner.nextInt();
                Flight newFlight = new Flight(flightNum, price, departureTime, arrivalTime, flightDuration, chosenAirline, new ArrayList<> (), null);
                chosenAirline.addFlight(newFlight);
                System.out.print("Flight added successfully ");
                break;

            case 2:
                chosenAirline.cancelFlight();
                System.out.print("Flight cancel successfully ");

                break;
            
            case 3:
                System.out.print("Enter id: ");
                int id = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();
                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();
                System.out.print("Enter crew member id: ");
                int crewMemberId = scanner.nextInt();
                System.out.print("Enter salary: ");
                int salary = scanner.nextInt();
                CrewMember newCrewMember = new CrewMember(id, firstName, lastName, chosenAirline, crewMemberId, salary);
                chosenAirline.addStaff(newCrewMember);    
                System.out.print("Flight added successfully ");
 
                break;

            case 4:
                chosenAirline.removeStaffMember();
                System.out.print("Crew member deleted successfully ");

                break;
            
            case 5:
                Airline chosenSubAirline = chooseAirlineByName(chosenAirline.getSubAirlines());

                

                break;
            default:
                System.out.println("Invalid choice! Try again");
                manageAirline(chosenAirline);
        }


    }


    
}
