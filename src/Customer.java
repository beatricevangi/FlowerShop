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
        //TODO
    }

    public int chooseProduct() {
        Catalog c = Catalog.getInstance();
        c.displayCatalog();
        System.out.println("Che prodotto vuoi aggiungere all'ordine?");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        return number;
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
