import java.util.Scanner;

public class LoginMenu implements Menu{

    @Override
    public void show() {
        Scanner in = new Scanner(System.in);
        Scanner inLog = new Scanner(System.in); // questo a che serve boh
        boolean quit = false; // questo x uscire dal menu
        int menuItem;

        do {
            System.out.println("Menu option:");
            System.out.println("1. Login");
            System.out.println("0. Quit");
            System.out.print("Choose menu item: ");
            try {
                menuItem = Integer.parseInt(in.next());
            } catch (Exception e) {
                menuItem = -1;
            }

            System.out.println(menuItem);
            switch (menuItem) {
                case 1:
                    System.out.println("Insert Email:");
                    String name = inLog.nextLine();
                    if (!Program.getInstance().checkEmail(name)) {
                        submit();
                    }
                    while (Program.getInstance().getCurrentUser() == null) {
                        System.out.println("Insert Password:");
                        String pass = inLog.nextLine();
                        Program.getInstance().login(name, pass);
                    }
                    quit = true;
                    break;

                case 2:
                    while (Program.getInstance().getCurrentUser() == null) {
                        submit();
                    }
                    quit = true;
                    break;
            }

            if (Program.getInstance().getCurrentUser() instanceof Florist) {
                Program.getInstance().setMenu(new MenuFlorist());
            }
            if (Program.getInstance().getCurrentUser() instanceof Customer) {
                Program.getInstance().setMenu(new MenuCustomer());
            }
        }
        while(!quit);
    }

    public void submit() {
        Scanner inLog = new Scanner(System.in);
        System.out.println("Are you a florist or a customer? ");
        String a = inLog.nextLine();
        String email = null;
        String name = null;
        String surname = null;
        String pass = null;
        String address = null;

        switch (a) {

            case "florist":
                System.out.println("Insert Email: ");
                email = inLog.nextLine();
                System.out.println("Insert Name: ");
                name = inLog.nextLine();
                System.out.println("Insert Surname: ");
                surname = inLog.nextLine();
                System.out.println("Insert Password: ");
                pass = inLog.nextLine();
                break;


            case "customer":
                System.out.println("Insert Email: ");
                email = inLog.nextLine();
                System.out.println("Insert Name: ");
                name = inLog.nextLine();
                System.out.println("Insert Surname: ");
                surname = inLog.nextLine();
                System.out.println("Insert Address: ");
                address = inLog.nextLine();
                System.out.println("Insert Password: ");
                pass = inLog.nextLine();
                break;

            default:
                System.err.println("Non puoi non essere né un fioraio né un cliente.");

        }
        if (!Program.getInstance().checkEmail(email))
            Program.getInstance().signIn(a, email, name, surname, address, pass);
    }

    public LoginMenu(){

    }
}