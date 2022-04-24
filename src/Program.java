import java.util.ArrayList;

public class Program {
    private OrderList ol = new OrderList();
    public static Program p = new Program();
    private final ArrayList<User> users;


    private User currentUser;
    private Menu menu;

    public Program(){
        currentUser = null;
        users = new ArrayList<User>();
        menu = null;
    }


    void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void createCatalog(){
        //TODO
    }

    public void createCustomer(){
        //TODO
    }


    public void login(String name, String pass){
        //TODO
    }

    public static Program getInstance(){
        return p;
    }

    public void viewMyOrders(Customer c){
        ol.printCustomerOrders(c);
    }

    public void pushOrder(Order o){
        ol.putOrder(o);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void deleteOrder(){}
}
