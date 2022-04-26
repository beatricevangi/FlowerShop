import java.util.Scanner;

public class MenuFlorist implements Menu{

    @Override
    public void show() {
        //todo
        int menuItem;
        boolean logout = false;
        Florist currentFlorist = null;

        if(Program.getInstance().getCurrentUser() instanceof Florist){
            currentFlorist = (Florist) Program.getInstance().getCurrentUser();
        }
        else {
            Program.getInstance().setMenu(new LoginMenu());
        }

        do{
            System.out.println("ready to sgobb, "+ currentFlorist.getName() +"? " +
                    "FLORIST SHOPPE is yours bro, ur the gvng,  don't change, loyal to tha stryt");
            System.out.println("1: fill order");
            System.out.println("2: view order list");
            System.out.println("0: logout");


            Scanner input = new Scanner(System.in);
            menuItem = input.nextInt();

            switch(menuItem){
                case 1:
                    currentFlorist.fillOrder();
                    break;

                case 2:
                    OrderList.getInstance().displayOrders();
                    break;

                case 0:
                    logout = true;
                    break;

                default:
                    System.err.println("Invalid input");
            }
        }
        while(!logout);
    }
}