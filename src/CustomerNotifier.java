import java.util.ArrayList;

public class CustomerNotifier implements Observer {

    @Override
    public void update(Object name) {
        System.out.println("Email in arrivo!" );
        if (name == null){
            //TODO email
            //sendMail(str = " ", c);
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


