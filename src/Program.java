public class Program {
    private OrderList ol = new OrderList();
    public static Program p = new Program();

    public void createCatalog(){
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

    public void pushOrder(Order o){
        ol.putOrder(o);
    }

    public void completeOrder(){
        //TODO
    }

    public void deleteOrder(){
        //TODO AAAAAAAAAA
    }
}
