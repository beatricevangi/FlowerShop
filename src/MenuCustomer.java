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
            Program.getInstance().getCurrentUser().setLogged(false);
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
                    currentCustomer.createOrder();
                    System.out.println("Order placed successfully.");
                    break;

                case 3:
                    currentCustomer.setLogged(false);
                    logout = true;
                    break;

                default:
                    System.err.println("Invalid input.");
            }
        } while(!logout);
    }

}
