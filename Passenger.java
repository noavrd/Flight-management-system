/**
 * The Passenger class represents individuals traveling on flights. It extends the Person class, inheriting attributes such as ID,
 * first name, and last name.
 * Each passenger is associated with a passport number and may be booked on multiple flights,
 * which are stored in an ArrayList. 
 * This class provides methods to retrieve the passport number and the list of flights associated with the passenger,
 * as well as functionality to add or remove flights from their itinerary.
 */

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
