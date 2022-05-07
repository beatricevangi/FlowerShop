package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User {
    private ArrayList<Message> inbox;

    public Customer(String email, String name, String surname, String address, String pass, boolean logged) {
        inbox = new ArrayList<>();
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.hashpass = pass;
        this.logged = logged;
        this.id = Program.getInstance().getNumUsers();
    }

    public void receiveMessage(Message m) {
        inbox.add(m);
    }

    public void viewInbox() {
        for (Message m : inbox) {
            if (!m.isRead()) {
                System.out.println("NEW MESSAGE!");
            }
            m.display();
        }
        if (inbox.size() == 0)
            System.out.println("There are no messages.\n");
    }

    public void clearInbox() {
        if (!inbox.isEmpty()) {
            inbox.get(0).writeMessageOnCSV(false);
            inbox = new ArrayList<>();
        }
    }

    public void placeOrder() {
        Catalog.getInstance().displayFloristCatalog();
        boolean done = false;
        ArrayList <Integer> productlist = new ArrayList<>();
        while(!done){
            productlist.add(chooseProduct());
            System.out.println("Product added to the order. Would you like to add any other item? (y/n)");
            Scanner input = new Scanner(System.in);
            char c = input.findInLine(".").charAt(0);
            if (c == 'n'){
                done = true;
            }
        }
        createOrder(productlist);
    }

    public int chooseProduct() {
        String r = null;
        int f;
        try {
            System.out.println("Select the number of the product that you want to add to your order.");
            Scanner input = new Scanner(System.in);
            r = input.nextLine();
            f = Integer.parseInt(r);

        } catch (Exception e) {
            System.err.println("ERROR invalid input: can't find the number " + r + " in the catalog.");
            Program.getInstance().hold(2);
            return chooseProduct();
        }
        if (f < 1 || f > Catalog.getInstance().getFloristCatSize()) {
            System.err.println("ERROR invalid input: can't find the number " + r + " in the catalog.");
            Program.getInstance().hold(2);
            return chooseProduct();
        } else {
            return f;
        }
    }

    public void createOrder(ArrayList<Integer> productlist) {
        Order newOrder = new Order(this);
        for (Integer i : productlist) {
            newOrder.addProduct(Catalog.getInstance().getFloristProduct(i));
        }
         OrderList.getInstance().putOrder(newOrder);
         Program.getInstance().getCustomerNotifier().addSubject(newOrder);
         newOrder.subscribe(Program.getInstance().getCustomerNotifier());
         newOrder.notify(null);
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}