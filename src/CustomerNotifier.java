import java.util.ArrayList;

public class CustomerNotifier implements Observer {
    private OrderList ol;

    @Override
    public void update(Object name) {
        System.out.println("Email in arrivo!" );
        if (name == null){
            //TODO email
            //sendMail(str = " ", c);
        }
        else {
            //TODO altra mail du cazz
            //sendMail(str, c);
        }
    }

    public void sendMail(String str, Customer c){
        // todo COME CAZZO ARRIVO ALL'emaila del CUSTOMER
    }
}
//https://www.lim.di.unimi.it/teaching/materiali/progmus/07_strutture_dinamiche.pdf?PHPSESSID=n706v97jqm6vbssviv7jjvvi97