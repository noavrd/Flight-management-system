import java.util.ArrayList;
import java.util.Scanner;

public class Airline implements AirlineCalculate {
    
    private String name;
    // using composite design pattern
    private ArrayList<Flight> airlineFlights;
    private ArrayList<Airline> subAirlines;
    private ArrayList<CrewMember> staff;

    Scanner scanner = new Scanner(System.in);


    public Airline(String name, ArrayList<Flight> airlineFlights, ArrayList<Airline> aubAirlines, ArrayList<CrewMember> Staff){
        this.name = name;
        this.airlineFlights =new ArrayList<Flight>();
        this.subAirlines = new ArrayList<Airline>();
        this.staff = new ArrayList<CrewMember>();
    }


    public String getName() {
        return name;
    }

    public ArrayList<Flight> getAirlineFlights(){
        return airlineFlights;
    }
    
    public ArrayList<Airline> getSubAirlines(){
        return subAirlines;
    }
    
    public ArrayList<CrewMember> getStaff(){
        return staff;
    }

    public void addFlight(Flight newFlight) {
        if (!airlineFlights.contains(newFlight)){
            airlineFlights.add(newFlight);
        }
    }

    public void cancelFlight() {
        if (this.getAirlineFlights() == null) {
            System.out.println("There are no flights available");
            return;
        }

        System.out.println("Choose flight to cancel: ");

        for (int i = 0; i < airlineFlights.size(); i++) {
           System.out.print(i + 1 + ". ");
           airlineFlights.get(i).printFlightDetails();
        }

        
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        airlineFlights.remove(airlineFlights.get(choice - 1));
    }

    public void addSubAirline(Airline newSubAirline){
        if (!subAirlines.contains(newSubAirline)) {
            subAirlines.add(newSubAirline);
        }
    }

    public void addStaff(CrewMember newCrewMember){
        if (!staff.contains(newCrewMember)) {
            staff.add(newCrewMember);
        }
    }

    public void removeStaffMember() {
        System.out.println("Choose crew member to remove: ");

        for (int i = 0; i < staff.size(); i++) {
           System.out.print(i + 1 + ". ");
           staff.get(i).printCrewMember();
        }

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        staff.remove(staff.get(choice));
    }


    public int getNumberOfStaff() {
        return staff.size();
    }

    // calculate paychecks to be able to calculate profits
    public int paychecks() {
        int total = 0;
    
        for (CrewMember crewMember : staff) {
            total += crewMember.getSalary();
        }

        for(Airline airline : subAirlines) {
            total += airline.paychecks();
        }

        return total;
    }

    @java.lang.Override
    public int totalFlights () {
        int total = 0;
        for(Flight flight : airlineFlights) {
            total += flight.totalFlights();
        }

        for(Airline airline : subAirlines) {
            total += airline.totalFlights();
        }

        return total;
    }

    @java.lang.Override
    public int totalPassengers () {
        int total = 0;
        for(Flight flight : airlineFlights) {
            total += flight.totalPassengers();
        }

        for(Airline airline : subAirlines) {
            total += airline.totalPassengers();
        }

        return total;
    }

    @Override
    public int totalProfits() {
        int total = 0;
        for(Flight flight : airlineFlights) {
            total += flight.totalPassengers() * flight.getPrice();
        }

        for(Airline airline : subAirlines) {
            total += airline.totalPassengers();
        }

        return total - this.paychecks();
    }

    public void printFlights() {
        if (this.getAirlineFlights() == null) {
            System.out.println("There are no flights available");
            return;
        }

        System.out.println(this.getName() + " flights: ");
        for (Flight flight: airlineFlights) {
            flight.printFlightDetails();
        }
    }

    
    public void printStaff() {
        if (this.getStaff() == null) {
            System.out.println("There are no staff available");
            return;
        }

        System.out.println(this.getName() + " staff: ");
        for (CrewMember crewMember: staff) {
            crewMember.printCrewMember();
        }
    }

    public void printSubAirlines() {
        if (this.getStaff() == null) {
            System.out.println("There are no sub airlines available");
            return;
        }

        System.out.println(this.getName() + " sub airlines:");
        for (Airline airline: subAirlines) {
            System.out.println(airline.getName());
        }
    }

}
