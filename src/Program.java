// TODO È UN SINGLETON
public class Program {
    private OrderList ol = new OrderList();
    public static Program p = new Program();

    public void createOrderManager(){
        //TODO AAAAAA
    }

    public void createCustomer(){
        //TODO
    }

    public void viewCatalog(){
        Catalog c = Catalog.getInstance();
    }

    public void login(){
        //TODO
    }

    public static Program getInstance(){
        return p;
    }

    public void viewMyOrders(Customer c){
        ol.printCustomerOrders(c);
    }

    public void createOrder(){
        //TODO
    }

    public void completeOrder(){
        //TODO
    }

    public void deleteOrder(){
        //TODO AAAAAAAAAA
    }


}
