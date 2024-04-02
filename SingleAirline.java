import java.util.ArrayList;

public class SingleAirline implements Airline {
    
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
        airlineFlights.add(newFlight);
    }

    public void addSubAirline(SingleAirline newSubAirline){
        subAirlines.add(newSubAirline);
    }

    
    public void addStaff(CrewMember newCrewMember){
        staff.add(newCrewMember);
    }

    // change
    @java.lang.Override
    public int totalFlights () {
        return 1;
    }

    @java.lang.Override
    public int totalPassengers () {
        return 1;
    }
}
