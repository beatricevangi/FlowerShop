import java.util.concurrent.TimeUnit;

public class ShippingCompany {

    public void ship(Box b){
        try {
            b.setOrderStatus("Shipped");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Order delivered. \n");
            b.setOrderStatus("Delivered");
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void schedulePickUp() {
        try {
            System.out.println("Withdrawl scheduled");
            System.out.wait(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
