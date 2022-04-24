import java.util.Scanner;

public class LoginMenu implements Menu{

    @Override
    public void show() {
        Scanner in = new Scanner(System.in);
        Scanner inLog = new Scanner(System.in); // questo a che serve boh
        boolean quit = false; // quetso x uscire dal menu
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
                    while (Program.getInstance().getCurrentUser() == null) {

                        System.out.println("Insert Username:");
                        String name = inLog.nextLine();
                        System.out.println("Insert Password:");
                        String pass = inLog.nextLine();
                        Program.getInstance().login(name, pass);
                    }
                    quit = true;
                    break;
            }
        } while (!quit);
    }

    public LoginMenu(){

    }
}
