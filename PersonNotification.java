public class PersonNotification {
    private Observer observer;
    private String message;

    public PersonNotification(Observer observer, String message) {
        this.observer = observer;
        this.message = message;
    }


    public void sendNotification(){
        observer.update(this);
    }

    public void printNotification(){
        Person newObserver = (Person) this.observer;
        System.out.println( newObserver.getFirstName() + " you just got new notification: " + message);
    }

    public String toString(){
        Person newObserver = (Person) this.observer;
        return "Notification for " + newObserver.getFirstName() + ": " + message;
    }
}