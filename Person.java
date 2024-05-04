import java.util.ArrayList;

public class Person implements Observer {
    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<PersonNotification> notifications;

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

    @Override
    public void update(PersonNotification newNotification) {
        notifications.add(newNotification);
    }

    public void printPersonNotifications() {
        System.out.println("There are " + notifications.size() + " new notifications for " + this.getFirstName() + ":");
        for (PersonNotification notification : notifications) {
            notification.printNotification();
        }
    }
}
