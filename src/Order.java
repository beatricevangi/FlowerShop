
import java.util.ArrayList;

public class Order {
    private int id;
    private float subtotal;
    private boolean isComplete;
    private Customer c;
    private ArrayList<Pair<Product, Integer>> pairArticles;
    private String status;

    Order(){
        isComplete = false;
        status = "processing";
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

    void addProduct(Product p){
        for(Pair<Product, Integer> pair : pairArticles){
            if(pair.first == p){
                pair.second = pair.second + 1;
            }
        }

        //TODO forse c'è da passare anche una quantità oppure direttamente pair in input
    }
}
