import java.util.ArrayList;

public class Airline implements AirlineCalculate {
    
    private String name;
    // using composite design pattern
    private ArrayList<Flight> airlineFlights;
    private ArrayList<Airline> subAirlines;
    private ArrayList<CrewMember> staff;

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

    public void cancelFlight(Flight flight) {
        airlineFlights.remove(flight);
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

    // אם הכל עובד לשנות את זה שיהיה גנרי ככה:

    // private int calculateTotal( String getByFlight, getByAirline ) {
    //     int total = 0;
    //     for(Flight flight : airlineFlights) {
    //         total += getByFlight;
    //     }

    //     for(Airline airline : subAirlines) {
    //         total += getByAirline;
    //     }

    //     return total;
    // }

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
            total += flight.totalPassengers();
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

        System.out.println(this.getName() + "Flights: ");
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

}
