
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
        //todo
    }

    public void fillOrder() {
        pickOrder();
        if (currentorder != null) {

            for (Product i : currentorder.getComponents()) {
                // todo controllare se è un bouquet o un flower o un decoration.
                Product currentproduct = s.getItem(i.getName());

            }
        } else {
            System.out.println("Non ci sono ordini da processare.");
        }
    }

}
