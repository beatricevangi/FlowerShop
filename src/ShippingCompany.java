import java.util.concurrent.TimeUnit;

public class ShippingCompany {

    public void ship(Box b){
        try {
            System.out.println("Order shipped.");
            b.setOrderStatus("Shipped");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Order delivered. \n");
            b.setOrderStatus("Delivered");
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void schedulePickUp() {
        try{
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Withdrawl scheduled.");
        }
        catch (InterruptedException e) {
            System.err.println("Error: interrupted exception.");
        }
    }
}
