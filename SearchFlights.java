/**
 * Interface representing the search method in the strategy pattern for searching flights.
 * Implementations should define specific search criteria.
 */

import java.util.ArrayList;

public interface SearchFlights {
    /**
     *
     * @return the flights according to the matching search type
    */
    ArrayList<Flight> search(ArrayList<Flight> flights);
}