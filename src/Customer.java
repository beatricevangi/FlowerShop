import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User{
    private ArrayList<Message> inbox;


    public Customer(String email, String name, String surname, String address, String pass, boolean logged){
        inbox = new ArrayList<Message>();
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.hashpass = pass;
        this.logged = logged;
        this.id = Program.getInstance().getNumUsers();
    }

    public void receiveMessage(Message m){
        inbox.add(m);
    }

    public void viewInbox(){
        for(Message m : inbox){
            if(!m.isRead()) {
                System.out.println("NEW MESSAGE!");
            }
            m.display();
        }
        if(inbox.size() == 0)
            System.out.println("There are no messages.\n");
    }

    public void clearInbox(){
        if(!inbox.isEmpty()) {
            inbox.get(0).writeMessageOnCSV(false);
            inbox = new ArrayList<>();
        }
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
            Program.getInstance().getCustomerNotifier().addSubject(newOrder);
            newOrder.subscribe(Program.getInstance().getCustomerNotifier());
            newOrder.notify(null);
        }
        else{
            System.err.println("Authentication failed.");
        }
    }

    public Product chooseProduct() {
        String r = null;
        int f;
        try {
            Catalog.getInstance().displayFloristCatalog();
            System.out.println("Select the number of the product to add to your order");
            Scanner input = new Scanner(System.in);
            r = input.nextLine();
            f = Integer.parseInt(r);

        } catch (Exception e) {
            System.out.println("ERROR invalid input: can't find the number " + r + "in the catalog.");
            Program.getInstance().hold(2);
            return chooseProduct();
        }
        if (f < 1 || f > Catalog.getInstance().getFloristCatSize()){
            System.out.println("ERROR invalid input: can't find the number " + r + "in the catalog.");
            Program.getInstance().hold(2);
            return chooseProduct();
        }
        else {
            return Catalog.getInstance().getFloristProduct(f);
        }
    }



    public String getEmail(){
        return email;
    }

    public String getAddress(){
        return address;
    }
}