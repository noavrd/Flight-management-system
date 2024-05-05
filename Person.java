/**
 * The Person class represents individuals within the system, such as crew members or passengers. 
 * It implements the Observer interface to enable them to receive notifications.
 * Each person has a unique ID, first name, and last name. 
 * Notifications are stored in an ArrayList, and the class provides methods to retrieve the person's ID, name, and notifications.
 * When a person receives a notification, it is added to their list of notifications.
 */

 import java.util.ArrayList;

public class Person implements Observer {
    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<String> notifications;

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.notifications = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public ArrayList<String> getNotifications() {
        return notifications;
    }

    @Override
    public void update(String newNotification) {
        notifications.add(newNotification);
    }

}
