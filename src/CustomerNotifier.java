public class CustomerNotifier implements Observer {
    private ArrayList<Subject> subjects;


    public CustomerNotifier(){
        subjects = new ArrayList<>();
    }


    @Override
    public void update(Object obj) { //obj è ordine, valutare se passare altro for the designn
        if (obj instanceof Order){
            sendMail((Order) obj);
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