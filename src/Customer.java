public class Customer {
    private String email;
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
}
