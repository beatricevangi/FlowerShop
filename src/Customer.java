import java.util.Scanner;

public class Customer extends User{
    private String address;

    private Order o;

    public Customer(String email, String name, String surname, String address, String pass){
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.password = pass;
    }

    public Customer(String email, String name, String surname, String address, String pass, boolean logged){
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.password = pass;
        this.logged = logged;
    }

    public void createOrder(){
        boolean notFinished = true;
        if(logged){
            Order newOrder = new Order(this);
            while(notFinished){
                newOrder.addProduct(chooseProduct());
                System.out.println("Prodotto aggiunto all'ordine. Vuoi aggiungere altro? (y/n) ");
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
            System.out.println("Devi prima autenticarti.");
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
            Program p = Program.getInstance();
            p.viewMyOrders(this);
        }
        else{
            System.out.println("Devi prima autenticarti.");
        }
    }

    public String getEmail(){
        return email;
    }

    public String getAddress(){
        return address;
    }
}
