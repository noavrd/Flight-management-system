/**
 * The Observer interface represents the first step in the observer pattern. 
 * It defines the contract for objects that receive updates from a subject.
 * Observers implement the update method to handle incoming messages.
 */

interface Observer {
    /**
     *
     * @return The update message.
    */
    void update(String message);
}