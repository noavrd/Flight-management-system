/**
 * The Airport class manages airlines, flights, crew members, passengers, and notifications
 * within the flight management system. It provides methods for adding mock data, searching flights,
 * watching and managing airline data, signing in and unsubscribing as observers, creating notifications,
 * and showing notifications for crew members or passengers. Acting as a central control unit,
 * it facilitates interactions between users and the flight management system.
 */

 import java.util.ArrayList;
import java.util.Scanner;

public class Airport {

    // Using singleton design pattern to ensure there is only one instance of Airport
    private static Airport instance;

    private String name;
    private ArrayList<Airline> airlines;
    
    Scanner scanner = new Scanner(System.in);

    // Singleton instance retrieval method
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
        Flight flight1 = new Flight(101, 200, 3, 6, 3, airline1, new ArrayList<>());
        Flight flight2 = new Flight(102, 250, 4, 7, 3, airline1, new ArrayList<>());
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
        Flight flight3 = new Flight(103, 20000, 10, 21, 11, airline2, new ArrayList<>());
        Flight flight4 = new Flight(104, 40000, 14, 18, 4, airline2, new ArrayList<>());
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
        Flight flight5 = new Flight(105, 200, 10, 15, 5, airline3, new ArrayList<>());
        Flight flight6 = new Flight(106, 280, 13, 16, 3, airline3, new ArrayList<>());
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


    // Choose airline to get it's data and method by user choice
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


    // Method to retrieve all flights across all airlines
    public ArrayList<Flight> getAllFlights() {
        ArrayList<Flight> flights = new ArrayList();
        for (Airline airline: airlines) {
            ArrayList<Flight> airlineFlights = airline.getAirlineFlights();
            for (Flight airlineFlight : airlineFlights) {
                flights.add(airlineFlight);
            }
        }

        return flights;
    }

    // Method to search for flights based on user input
    public void searchFlightsOptions() {
        System.out.println("Search by:");

        System.out.println("1. Price");
        System.out.println("2. Departure time");
        System.out.println("3. Flight duration");


        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        ArrayList<Flight> matchingFlights = new ArrayList<>();
        switch (choice) {
            case 1:
                System.out.println("Enter price: ");
                int price = scanner.nextInt();
                
                if (price <= 0) {
                    System.out.println("Invalid price!");
                    return;
                }

                SearchFlights searchByPrice = new SearchFlightsByPrice(price);
                ContextFlights searchFlightsA = new ContextFlights(searchByPrice);
                matchingFlights = searchFlightsA.performSearch(getAllFlights());

                for (Flight flight: matchingFlights) {
                    flight.printFlightDetails();
                }

                break;

            case 2:
                System.out.println("Enter departure time: ");
                int departureTime = scanner.nextInt();
                
                if (departureTime <= 0 || departureTime > 24) {
                    System.out.println("Invalid time!");
                    return;
                }


                SearchFlights searchByDepartureTime = new SearchFlightsByDepartureTime(departureTime);
                ContextFlights searchFlightsB = new ContextFlights(searchByDepartureTime);
                matchingFlights = searchFlightsB.performSearch(getAllFlights());

                for (Flight flight: matchingFlights) {
                    flight.printFlightDetails();
                }
                break;

            case 3:
                System.out.println("Enter flight duration: ");
                int flightDuration = scanner.nextInt();
                
                if (flightDuration <= 0 || flightDuration > 18) {
                    System.out.println("Invalid time!");
                    return;
                }

                SearchFlights searchByDuration = new SearchFlightsByDuration(flightDuration);
                ContextFlights searchFlightsC = new ContextFlights(searchByDuration);
                matchingFlights = searchFlightsC.performSearch(getAllFlights());
            
                for (Flight flight: matchingFlights) {
                    flight.printFlightDetails();
                }
                  
                break;
            default:
                System.out.println("Invalid choice! Try again");
                searchFlightsOptions();
        }
    }

    // A function to choose if to watch or manage the airline data
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

    // A function to watch airline data by user choice
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

    // A function to show and act some methods on airlines
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
                Flight newFlight = new Flight(flightNum, price, departureTime, arrivalTime, flightDuration, chosenAirline, new ArrayList<> ());
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
                watchAirline(chosenSubAirline);
                break;

            default:
                System.out.println("Invalid choice! Try again");
                manageAirline(chosenAirline);
        }
    }

     // Method for crew member or passenger to sign in as an observer
    public void signInAsObserver() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
    
        for (Airline airline : airlines) {
            CrewMember crewMember = airline.findCrewMember(id);
            Passenger passenger = airline.findPassenger(id);
            if (crewMember != null) {
                airline.subscribe(crewMember);
                System.out.println("Signed to be an observer successfully");
                return;

            } else if (passenger != null){
                airline.subscribe(passenger);
                System.out.println("Signed to be an observer successfully");
                return;


            } else {
                System.out.println("ID does not exist, you can't sign in to be an observer");
                return;
            }
        }

    }
    
    // Method for crew member or passenger to unsubscribe as an observer
    public void unsubscribeAsObserver() {

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

       for (Airline airline : airlines) {
                CrewMember crewMember = airline.findCrewMember(id);
                Passenger passenger = airline.findPassenger(id);
            if (crewMember != null) {
                airline.unsubscribe(crewMember);
                System.out.println("Unsubscribe as observer successfully");
                return;

            } else if (passenger != null){
                airline.unsubscribe(passenger);
                System.out.println("Unsubscribe as observer successfully");
                return;
            }
            else {
                System.out.println("Id not exist, you can't unsubscribe to be observer");
                return;
            }
        } 
    }

    // Method to create new notification for crew member or passenger
    public void createNotification() {
        System.out.println("First enter airline to create a new notification: ");
        Airline chosen = chooseAirlineByName(airlines);
        scanner.nextLine(); 
        System.out.println("Enter the new notification: ");
        String message = scanner.nextLine();
        chosen.notify(message);

    }

    // Method to choose if a crew member or a passenger will view their notifications
    public void choosePersonToShow() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
    
        for (Airline airline : airlines) {
            CrewMember crewMember = airline.findCrewMember(id);
            Passenger passenger = airline.findPassenger(id);
            if (crewMember != null) {
                showMyNotifications(crewMember);
                return;
            } else if (passenger != null){
                showMyNotifications(passenger);
                return;
            } else {
                System.out.println("ID does not exist");
                return;
            }
        }

    }

    // Method to show notifications for a crew member or passenger
    public void showMyNotifications(Person person) {
        ArrayList<String> notifications = person.getNotifications();
        if (notifications.isEmpty()) {
            System.out.println("No notifications for " + person.getFirstName());
        } else {
            System.out.println("Notifications for " + person.getFirstName() + ":");
            for (String notification : notifications) {
                System.out.println(notification);
            }
        }
    }
}
