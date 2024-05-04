/*
* Create an interface to use in strategy pattern to represent the search method
*/

import java.util.ArrayList;

public interface SearchFlights {
    /**
     *
     * @return the flights according to the matching search type
    */
    ArrayList<Flight> search(ArrayList<Flight> flights);
}