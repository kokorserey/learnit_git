package observerPatter;

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class ConcreteSubject implements Subject {
    private int state;
    private List<Observer> observers = new ArrayList<>();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

// Observer interface
interface Observer {
    void update(int state);
}

// Concrete Observer
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int state) {
        System.out.println("Observer " + name + " updated with state: " + state);
    }
}

// Client code
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create a subject
        ConcreteSubject subject = new ConcreteSubject();

        // Create observers
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        // Register observers with the subject
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // Set the state of the subject, triggering updates to observers
        subject.setState(10);

        // Remove an observer
        subject.removeObserver(observer1);

        // Set the state again
        subject.setState(20);
    }
}
