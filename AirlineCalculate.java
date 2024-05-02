/*
 * Strategy Pattern:
 * The AirlineCalculate interface defines a family of methods to calculate
 * airline metrics (totalFlights, totalPassengers, totalProfits).
 * Different implementations of this interface can be provided to switch between strategies at runtime.
 */
public interface AirlineCalculate {
    /**
     *
     * @return number of flights the airline has.
    */
    int totalFlights ();

    /**
     *
     * @return The number of passengers the airline has.
    */
    int totalPassengers();

    /**
     *
     * @return The airline profits.
    */
    int totalProfits();
}
