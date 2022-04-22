import java.util.ArrayList;

public class Box {
    private Order o;
    private ArrayList<Product> products = new ArrayList<Product>();
    private boolean isClosed;

    public Box(Order o){
        this.o = o;
        isClosed = false;
    }

    public void pack(Product p){
        products.add(p);
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void close() {
        isClosed = true;
    }

    public void setOrderStatus(String s){
        o.setStatus(s);
    }

}
