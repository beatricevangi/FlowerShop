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

    public void run(){
        //todo sistema quit

        while(!quit){
            menu.show();
        }
    }

    public void login(String email, String encoded){
        for(User u : users){
            if(u.getEmail() == email){
                if(u.getHashPass() == encoded){
                    System.out.println("Successfully logged in");
                    u.setLogged(true);
                    currentUser = getUser(email);
                }
                else{
                    System.out.println("Wrong password!");
                    currentUser = null;
                }
            }
        }
    }

    public void signIn(String category, String email, String name, String surname, String address, String encoded){
        if (category == "customer"){
            currentUser = new Customer(email, name, surname, address, encoded, true);
            users.add(currentUser);
        }

        if(category == "florist"){
            currentUser = new Florist(email, name, surname, address, encoded, true);
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

    public static synchronized Program getInstance(){
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

    public User getUser(String email){
        for(User u : users){
            if(u.getEmail() == email){
                return u;
            }
        }
        return null;
    }

    public void deleteOrder(){}
}
