import java.util.ArrayList;

public class OrderList implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    public static OrderList ol = new OrderList();

    public static synchronized OrderList getInstance(){
        return ol;
    }

    public int getSize(){
        return orders.size();
    }

    public Order getOrder() {
        int count = 0;
        for (Order order : orders) {
            if (order.isComplete()) {
                count++;
            } else {
                return orders.get(count);
            }
        }
        return null;
    }



    public void putOrder(Order o) {
        this.orders.add(o);
        notify(o.getCostumer());
    }

    public void displayOrders(){
        System.out.println("Completati:");
        for(Order o : orders){
            o.displayOrderFloristPOV();
        }
    }

    public void removeOrder(Order o) {
        this.orders.remove(o);
    }

    @Override
    public void notify(Object obj) {
        for (Observer o : observers) {
            o.update(obj);
        }
    }

    public void printCustomerOrders(Customer c) {
        for (Order o : orders) {
            if (o.getCostumer() == c) {
                o.displayOrderCustomerPOV();
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