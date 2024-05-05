
/**
 * The PersonNotification class represents a notification sent to a specific observer (person).
 * It contains a reference to the observer and the notification message.
 * When a notification is sent, it calls the observer's update method to add the message to their notifications list.
 * The printNotification method is used to print the notification message along with the observer's first name.
 */
 public class PersonNotification {
    private Observer observer;
    private String message;

    public PersonNotification(Observer observer, String message) {
        this.observer = observer;
        this.message = message;
    }

    public void sendNotification(){
        observer.update(message);
    }

    public void printNotification(){
        Person newObserver = (Person) this.observer;
        System.out.println( newObserver.getFirstName() + " you just got new notification: " + message);
    }
}