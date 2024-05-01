import java.util.ArrayList;

public class Airline implements AirlineCalculate {
    
    private String name;
    private ArrayList<Flight> airlineFlights;
    private ArrayList<SingleAirline> subAirlines;
    private ArrayList<CrewMember> staff;

    public SingleAirline(String name, ArrayList<Flight> airlineFlights, ArrayList<SingleAirline> aubAirlines, ArrayList<CrewMember> Staff){
        this.name = name;
        this.airlineFlights =new ArrayList<Flight>();
        this.subAirlines = new ArrayList<SingleAirline>();
        this.staff = new ArrayList<CrewMember>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Flight> getAirlineFlights(){
        return airlineFlights;
    }
    
    public ArrayList<SingleAirline> getSubAirlines(){
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

    public void addSubAirline(SingleAirline newSubAirline){
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

        for(SingleAirline airline : subAirlines) {
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

    //     for(SingleAirline airline : subAirlines) {
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

        for(SingleAirline airline : subAirlines) {
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

        for(SingleAirline airline : subAirlines) {
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

        for(SingleAirline airline : subAirlines) {
            total += airline.totalPassengers();
        }

        return total - this.paychecks();
    }

}
