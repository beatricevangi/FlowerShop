import java.lang.reflect.Array;
import java.util.ArrayList;

public class Florist extends User {
    private OrderList ol;
    private Order currentorder;
    private Storage s;
    private ShippingCompany sc;

    public Florist(String email, String name, String surname, String address, String pass, boolean log){
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.password = pass;
    }

    public void pickOrder() {
        Order currentorder = ol.getOrder();
    }

    public void sendOrder(Box b) {
            callShippingCompany();
            sc.ship(b);
    }

    public void callShippingCompany() {
        sc.schedulePickUp();
    }

    public void fillOrder() {
        pickOrder();
        if (currentorder != null) {
            Box box = new Box(currentorder);
            for (Product i : currentorder.getComponents()) {
                if (i instanceof Flower || i instanceof Decoration) {
                    box.pack(s.getItem(i.getName()));
                } else {
                    Bouquet b = new Bouquet(new String(i.getName()));
                    // in questo caso abbiamo un Bouquet
                    for (int itr = 0; itr < ((Bouquet) i).getSize(); itr++) {
                        Product tmp = ((Bouquet) i).getItem(itr);
                        b.addItem(s.getItem(tmp.getName()));
                    }
                    box.pack(b);
                }
            }
            box.close();
            currentorder.setComplete(true);
            currentorder.setStatus("Ready");
            System.out.println("L'ordine " + currentorder.getId() + " è stato completato.");
            sendOrder(box);
        } else {
            System.out.println("Non ci sono ordini da processare.");
        }
    }
}
