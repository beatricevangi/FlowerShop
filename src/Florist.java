
public class Florist extends User {
    public OrderList ol;
    public Order currentorder;
    public Storage s;
    public ShippingCompany sc;

    public void createProduct(){

    }

    public void pickOrder(){
        Order currentorder = ol.getOrder();
    }

    public void sendOrder(){

    }

    public void callShippingCompany(){

    }

    public void fillOrder(){
        pickOrder();
        if (currentorder != null){

            for(Product i : currentorder.getComponents() ){
                Product currentproduct = s.getItem(i.getName());
                
            }
        }
        else{
            System.out.println("Non ci sono ordini da processare.");
        }
    }

}
