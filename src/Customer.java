import java.util.Scanner;

public class Customer extends User{

    public Customer(String email, String name, String surname, String address, String pass, boolean logged){
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.encodedpass = pass;
        this.logged = logged;
        this.id = Program.getInstance().getNumUsers();
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
            OrderList.getInstance().putOrder(newOrder);
        }
        else{
            System.err.println("Authentication failed.");
        }
    }

    public Product chooseProduct() {
        Catalog c = Catalog.getInstance();
        c.displayFloristCatalog();
        System.out.println("Select the number of the product to add to your order");
        Scanner input = new Scanner(System.in);
        return Catalog.getInstance().getFloristProduct(input.nextInt());
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