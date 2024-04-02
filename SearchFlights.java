import java.util.ArrayList;

public interface SearchFlights {
    /**
     *
     * @return the flights according to the matching search type
    */
    ArrayList<Flight> search(ArrayList<Flight> flights);
}