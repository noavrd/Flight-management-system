import java.util.ArrayList;

class PersonNotification implements Notification {
    private ArrayList<Observer> observers;

    public PersonNotification() {
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public void printNotification(String message){
        System.out.println(message);
    }
}
