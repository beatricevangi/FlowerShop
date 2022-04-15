import java.util.ArrayList;

public class OrderList implements Subject{
    private ArrayList<Order> o = new ArrayList<>();

    public ArrayList<Order> getOrder() {
        return o;
    }

    public void putOrder(Order o){
        this.o.add(o);
    }

    public void removeOrder(Order o){
        this.o.remove(o);
    }

    @Override
    public void notify(Object obj){
        //TODO
    }

    @Override
    public void subscribe(Observer o){
        //TODO
    }

    @Override
    public void unsubscribe(Observer o) {
        //TODO
    }

}
