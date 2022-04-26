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

    public void setStatus(String str){
        status = str;
    }

    public Customer getCostumer(){ return c; }

    public void displayOrderFloristPOV(){
        System.out.println("ID: " + id);
        System.out.println("CUSTOMER: " +  c);
        System.out.println("CONTENT:  ");
        for(Product a : articles)
            a.display();
        if(isComplete)
            System.out.println("\n COMPLETED");
        else
            System.out.println("TO BE DONE");
    }

    public void displayOrderCustomerPOV(){
        System.out.println("ID: " + id);
        System.out.println("CONTENT:  " );
        for(Product a : articles)
            a.display();
        System.out.println("SUBTOTAL" + subtotal);
        System.out.println("STATUS: " + status);
    }

    public boolean isComplete(){
        return isComplete;
    }

    void setComplete(boolean c){
        isComplete = c;
    }

    void addProduct(int num){
        Product p = Catalog.getInstance().getFloristProduct(num);
        articles.add(p);
        subtotal += p.getPrice();
    }

    ArrayList<Product> getComponents(){
        return articles;
    }
}
