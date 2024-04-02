import java.util.ArrayList;

public class Passenger extends Person {
    private Person person;
    private int passportNumber;
    private ArrayList<Flight> flights;

    public Passenger(int id, String firstName, String lastName, int passportNumber) {
        super(id, firstName, lastName);
        this.passportNumber = passportNumber;
        this.flights = new ArrayList<Flight>();
    }

    public int getPassportNumber(){
        return passportNumber;
    }

    public Person getPerson(){
        return person;
    }

    public ArrayList<Flight> getFlights(){
        return flights;
    }

    public void addNewFlight(Flight newFlight) {
        if (!flights.contains(newFlight)) {
            flights.add(newFlight);
            newFlight.addPassenger(this);
        }
    }

    public void removeFlight(Flight newFlight) {
            flights.remove(newFlight);        
    }
  
}
