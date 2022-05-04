import java.util.Scanner;

public class InboxMenu implements Menu {
    private Customer currentCustomer = null;

    public InboxMenu(Customer currentCustomer){
        this.currentCustomer = currentCustomer;
    }

    @Override
    public void show() {
        int menuItem;
        boolean quit = false;


        do {
            System.out.println("Choose an option below:");
            System.out.println("1: View new messages");
            System.out.println("2: Empty inbox");
            System.out.println("0: Quit");

            currentCustomer = (Customer) Program.getInstance().getCurrentUser();

            Scanner input = new Scanner(System.in);
            menuItem = input.nextInt();

            switch(menuItem){
                case 1:
                    currentCustomer.viewInbox();
                    break;

                case 2:
                    currentCustomer.cleanInbox();
                    System.out.println("Inbox emptied successfully.");
                    break;

                case 0:
                    Program.getInstance().setMenu(new MenuCustomer());
                    quit = true;
                    break;
            }
        } while (!quit);
    }


}
