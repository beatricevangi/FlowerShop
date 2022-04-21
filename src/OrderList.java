import java.util.ArrayList;

public class OrderList implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private ArrayList<Order> o = new ArrayList<>();

    public Order getOrder() {
        int count = 0;
        for (Order order : o){
            if (order.isComplete()){
                count++;
            }
            else{
                return o.get(count);
            }
        }
        return null;
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

    public void printCustomerOrders(Customer c){
        for(Order o : o){
            if(o.getCostumer() == c){
                o.displayOrder();
            }
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