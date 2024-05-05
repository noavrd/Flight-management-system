/**
 * The NotificationCenter interface defines methods for managing subscribers and sending notifications.
 * It includes operations to subscribe observers, unsubscribe observers, and notify all observers about an event with a message.
 */

public interface NotificationCenter {

   /**
    * Adds an observer to the list of subscribers.
    */
   void subscribe(Person observer);

   /**
    * Removes an observer from the list of subscribers.
    */
   void unsubscribe(Person observer);

   /**
    * Notifies all observers about an event with a message.
    */
   void notify(String message);
} 
