/* 
 Create ContextFlights class to except the strategy pattern
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



   
