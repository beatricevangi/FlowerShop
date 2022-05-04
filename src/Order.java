import java.util.ArrayList;

public class Order implements Subject{
    private final int id;
    private float subtotal;
    private boolean isComplete;
    private Customer c;
    private ArrayList<Product> articles;
    private String status;

    Order(Customer c){
        isComplete = false;
        status = "Processing";
        subtotal = 0;
        this.c = c;
        articles = new ArrayList<>();
        this.id = OrderList.getInstance().getSize();
    }

    public void displayOrderFloristPOV(){
        System.out.println("\n");
        System.out.println("Order ID:  #" + id);
        System.out.println("CUSTOMER:  " +  c.getName() + " " + c.getSurname());
        System.out.println("CONTENT:  ");
        for(Product a : articles)
            a.display();
        if(isComplete)
            System.out.println("                        COMPLETED");
        else
            System.out.println("                        TO BE DONE");
    }

    public void displayOrderCustomerPOV(){
        System.out.println("ID:  " + id);
        System.out.println("CONTENT:  " );
        for(Product a : articles)
            a.display();
        String str = String.format("%.02f", subtotal);
        System.out.println("TOTAL: " + str + "€");
        System.out.println("STATUS: " + status);
        System.out.println("\n");
    }

    void addProduct(Product p){
        articles.add(p);
        subtotal += p.getPrice();
    }

    public int getId() {
        return id;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setStatus(String str){
        status = str;
        OrderList.getInstance().refreshCSV(this);
        notify(null);
    }

    public Customer getCustomer(){ return c; }

    public ArrayList<Product> getComponents(){
        return articles;
    }

    public String getStatus() { return status; }

    public boolean isComplete(){
        return isComplete;
    }

    void setComplete(boolean c){
        isComplete = c;
    }


}
