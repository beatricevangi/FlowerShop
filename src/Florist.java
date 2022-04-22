
public class Florist extends User {
    public OrderList ol;
    public Order currentorder;
    public Storage s;
    public ShippingCompany sc;

    public void createProduct() {
        //todo
    }

    public void pickOrder() {
        Order currentorder = ol.getOrder();
    }

    public void sendOrder() {
        //todo
    }

    public void callShippingCompany() {
        sc.schedulePickUp();
    }

    public void fillOrder() {
        pickOrder();
        if (currentorder != null) {

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
        } else {
            System.out.println("Non ci sono ordini da processare.");
        }
    }

}
