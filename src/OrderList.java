import java.util.ArrayList;

public class OrderList implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private ArrayList<Order> o = new ArrayList<>();

    public ArrayList<Order> getOrder() {
        return o;
    }

    public void putOrder(Order o) {
        this.o.add(o);
        notify(o.getCostumer());
    }

    public void removeOrder(Order o) {
        this.o.remove(o);
    }

    @Override
    public void notify(Object obj) {
        for (Observer o : observers) {
            o.update(obj);
        }
    }

    @Override
    public void subscribe(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void unsubscribe(Observer obs) {
        observers.remove(obs);
    }
}