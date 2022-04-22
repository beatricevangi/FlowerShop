public class ShippingCompany {
    private String name;

    public void ship(Box b){
        try {
            b.setOrderStatus("Shipped");
            System.out.print("Ci pensa Bartolini!");
            System.out.wait(1000);
            b.setOrderStatus("Delivered");
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
