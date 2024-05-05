/**
 * The ContextFlights class implements the strategy pattern for searching flights.
 * It accepts different search strategies and performs searches based on the selected strategy.
 * The performSearch method executes the search strategy on a list of flights
 * and returns the matching flights.
 */

import java.util.ArrayList;

public class ContextFlights {
    private SearchFlights searchStrategy;

    public ContextFlights(SearchFlights searchStrategy){
       this.searchStrategy = searchStrategy;
    }
 
    public ArrayList<Flight> performSearch(ArrayList<Flight> flights) {
      return searchStrategy.search(flights);
  }
}



   
