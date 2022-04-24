import java.util.Scanner;

public class Customer extends User{
    private String address;
    private boolean logged;

    private Order o;

    public Customer(String email, String address, String logged){
        this.email = email;
        this.address = address;
        this.logged = false;
    }

    public void createOrder(){
        boolean notFinished = true;
        if(logged){
            Order newOrder = new Order(this);
            while(notFinished){
                int num = chooseProduct();
                newOrder.addProduct(num);
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
        System.out.println("Che prodotto vuoi aggiungere all'ordine?");
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

    public void login(){
        logged = true;
        System.out.println("Login completato con successo!");
    }

    public String getEmail(){
        return email;
    }

    public String getAddress(){
        return address;
    }
}
