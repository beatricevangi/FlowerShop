import java.util.Scanner;

public class Customer extends User{
    private String address;

    private Order o;

    public Customer(String email, String name, String surname, String address, String pass){
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.encodedpass = pass;
    }

    public Customer(String email, String name, String surname, String address, String pass, boolean logged){
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.encodedpass = pass;
        this.logged = logged;
    }

    public void createOrder(){
        boolean notFinished = true;
        if(logged){
            Order newOrder = new Order(this);
            while(notFinished){
                newOrder.addProduct(chooseProduct());
                System.out.println("Product added to the order. Would you like to add any other item? (y/n)");
                Scanner input = new Scanner(System.in);
                char c = input.findInLine(".").charAt(0);
                if (c == 'n'){
                    notFinished = false;
                }
            }
            Program p = Program.getInstance();
            p.pushOrder(newOrder);
        }
        else{
            System.err.println("Authentication failed.");
        }
    }

    public int chooseProduct() {
        Catalog c = Catalog.getInstance();
        c.displayFloristCatalog();
        System.out.println("Select the number of the product to add to your order");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public void myOrders(){
        if(logged) {
           OrderList.getInstance().printCustomerOrders(this);
        }
    }

    public String getEmail(){
        return email;
    }

    public String getAddress(){
        return address;
    }
}
