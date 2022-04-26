import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Program {
    private OrderList ol = new OrderList();
    public static Program p = new Program();
    private final ArrayList<User> users;
    private User currentUser;
    private Menu menu;

    private boolean quit;

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

    public void signIn(String category, String email, String name, String surname, String address, String pass){
        if (category == "customer"){
            currentUser = new Customer(email, name, surname, address, pass, true);
            users.add(currentUser);
        }

        if(category == "florist"){
            currentUser = new Florist(email, name, surname, address, pass, true);
            users.add(currentUser);
        }
    }

    public boolean checkEmail(String str){
        for(User u : users){
            if(u.getEmail() == str){
                return true;
            }
        }
        return false;
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
