import java.util.ArrayList;

public class SearchFlightsByPrice implements SearchFlights {
    private int price;

    public SearchFlightsByPrice(int price){
        this.price = price;
    }

    // search flight that departure on given time
    @Override
    public ArrayList<Flight> search(ArrayList<Flight> flights) {
        ArrayList<Flight> results = new ArrayList<Flight>();

        for (Flight flight : flights) {
            if (flight.getPrice() == price) {
                results.add(flight);
            }
        }

        return results;
    }
}
