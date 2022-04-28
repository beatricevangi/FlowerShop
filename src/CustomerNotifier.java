import java.util.ArrayList;

public class CustomerNotifier implements Observer {

    @Override
    public void update(Object obj) { //obj è ordine
        if (obj instanceof Order){
            sendMail(((Order) obj).getCustomer(), ((Order) obj).isComplete());
        }
        else {
            System.out.println("Order not received.");
        }
    }

    public void sendMail(Customer c, boolean isComplete){
        if (isComplete){
            //todo
        }
        else{
            //todo
        }
    }
}


