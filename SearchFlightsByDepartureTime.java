/**
 * Implementation of SearchFlights interface to search for flights by departure time.
 */

import java.util.ArrayList;

public class SearchFlightsByDepartureTime implements SearchFlights {
    private int departureTime;

    public SearchFlightsByDepartureTime(int departureTime){
        this.departureTime = departureTime;
    }

    // search flight that departure on given time
    @Override
    public ArrayList<Flight> search(ArrayList<Flight> flights) {
        ArrayList<Flight> results = new ArrayList<Flight>();

        for (Flight flight : flights) {
            if (flight.getDepartureTime() == departureTime) {
                results.add(flight);
            }
        }

        return results;
    }
}
