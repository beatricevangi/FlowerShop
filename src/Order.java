
import java.util.ArrayList;


public class Order {
    private int id;
    private float subtotal;
    private boolean isComplete;
    private Customer c;
    private ArrayList<Product> articles;
    private String status;
    static int idCounter = 0;

    Order(Customer c){
        isComplete = false;
        status = "processing";
        subtotal = 0;
        id = idCounter;
        idCounter ++;
    }

    public int getId() {
        return id;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public String checkStatus(){
        return status;
    }

    public Customer getCostumer(){ return c; }

    public void displayOrder(){
        System.out.println("ID: " + id);
        System.out.println("COSTUMER: " +  id);
        System.out.println("CONTENT:  " +  articles);
        System.out.println("STATUS: " + status);
    }

    void setComplete(boolean c){
        isComplete = c;
    }

    void addProduct(int num){
        Catalog c = Catalog.getInstance();
        Product p = c.getProduct(num);
        articles.add(p);
        subtotal += p.getPrice();
    }
}
