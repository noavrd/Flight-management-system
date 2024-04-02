import java.util.ArrayList;

public class SearchFlightsByDuration implements SearchFlights {
    private int flightDuration;

    public SearchFlightsByDuration(int flightDuration){
        this.flightDuration = flightDuration;
    }

    // search flight that departure on given time
    @Override
    public ArrayList<Flight> search(ArrayList<Flight> flights) {
        ArrayList<Flight> results = new ArrayList<Flight>();

        for (Flight flight : flights) {
            if (flight.geFlightDuration() == flightDuration) {
                results.add(flight);
            }
        }

        return results;
    }
}
