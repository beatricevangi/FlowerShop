
import java.util.ArrayList;

public class Order {
    private int id;
    private float subtotal;
    private boolean isComplete;
    private ArrayList<Pair> pairArticles;
    private String status;


    public int getId() {
        return id;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public String checkStatus(){
        return status;
    }

    public void displayOrder(){
        //TODO
    }

    void setComplete(){
        //TODO E DECIDERE VISIBILITÀ
    }

    void addProduct(Product p){
        //TODO forse c'è da passare anche una quantità oppure direttamente pair in input
    }
}
