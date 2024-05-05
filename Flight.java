/**
 * The Flight class represents a flight within an airline. It stores information
 * such as flight number, price, departure time, arrival time, and flight duration.
 * Flights are associated with an airline and can have passengers booked on them.
 * The class provides methods to retrieve and modify flight details, add and remove passengers,
 * and calculate total profits, total flights, and total passengers for the flight.
 */

 import java.util.ArrayList;

public class Flight implements AirlineCalculate {
    private int flightNumber;
    private int price;
    private int departureTime;
    private int arrivalTime;
    private int flightDuration;
    private Airline airline;
    private ArrayList<Passenger> passengers;

   public Flight(int flightNumber, int price, int departureTime, int arrivalTime, int flightDuration,  Airline airline, ArrayList<Passenger> passengers) {
        this.flightNumber = flightNumber;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightDuration = flightDuration;
        this.airline = airline;
        this.passengers =  new ArrayList<Passenger>();
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public int getPrice() {
        return price;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int geFlightDuration() {
        return flightDuration;
    }
       
    public Airline getAirline() {
        return airline;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
        
    public void setFlightNumber(int newFlightNumber) {
        flightNumber = newFlightNumber;
    }
 
    public void setPrice(int newPrice) {
        price = newPrice;
    }
 
    public void setDepartureTime(int newDepartureTime) {
        departureTime = newDepartureTime;
    }
    
    public void setArrivalTime(int newArrivalTime) {
        arrivalTime = newArrivalTime;
    }


    public void setFlightDuration(int newFlightDuration) {
        flightDuration = newFlightDuration;
    }

    public void setAirline(Airline newAirline) {
        airline = newAirline;
    }

    public void addPassenger(Passenger newPassenger) {
        passengers.add(newPassenger);
    }

    public int getNumberOfPassengers() {
        return passengers.size();
    }

    @java.lang.Override
    public int totalFlights () {
        return 1;
    }

    @java.lang.Override
    public int totalPassengers () {
        return getNumberOfPassengers();
    }

    @Override
    public int totalProfits() {
        return getPrice();
    }

    public void removePassenger(Passenger passenger){
        if (passengers.contains(passenger)){
            passenger.removeFlight(this);
            passengers.remove(passenger);
        }
    }

    public void printFlightDetails() {
        System.out.println("Flight number: " + this.getFlightNumber() + ", Departure time: " + this.getDepartureTime() + ", Arrival time: " + this.getArrivalTime());
    }
}