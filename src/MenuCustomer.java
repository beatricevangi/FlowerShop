import java.util.Scanner;

public class MenuCustomer implements Menu{

    @Override
    public void show() {
        int menuItem;
        boolean logout = false;
        Customer currentCustomer = null;

        if(Program.getInstance().getCurrentUser() instanceof Customer){
            currentCustomer = (Customer) Program.getInstance().getCurrentUser();
        }
        else {
            Program.getInstance().setMenu(new LoginMenu());
        }

        do {
            System.out.println("Welcome to the FLORIST SHOP, " + currentCustomer.getName());
            System.out.println("1: my orders");
            System.out.println("2: place an order");
            System.out.println("3: logout");

            Scanner input = new Scanner(System.in);
            menuItem = input.nextInt();

            switch (menuItem) {
                case 1:
                    System.out.println("Here's your order list :)");
                    OrderList.getInstance().printCustomerOrders(currentCustomer);
                    break;

            case 2:
                // TODO si apre il coso degli ordini fatti dall'utente
                p = Program.getInstance();
                // p.
                break;

            case 3:
                // TODO si apre il coso per fare ordini
                break;

            default:
                System.err.println("Input non valido");
        }
    }

}
