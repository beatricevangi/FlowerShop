import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginMenu implements Menu {

    MessageDigest md;
    public LoginMenu() {
        try {
            md = MessageDigest.getInstance("SHA-256");

        }
        catch (NoSuchAlgorithmException e){
            System.err.print("ERROR");
        }
    }



    @Override
    public void show() {
        Scanner in = new Scanner(System.in);
        Scanner inLog = new Scanner(System.in);
        boolean quit = false; // questo x uscire dal menu
        int menuItem;
        do {
            System.out.println("Menu option:");
            System.out.println("1. login");
            System.out.println("2. sign in");
            System.out.println("0. quit");
            System.out.print("Choose menu item: ");
            try {
                menuItem = Integer.parseInt(in.next());
            } catch (Exception e) {
                menuItem = -1;
            }

            System.out.println(menuItem);
            switch (menuItem) {

                case 0:
                    quit = true;
                    break;

                case 1:
                    System.out.println("LOGIN MENU");
                    System.out.println("Insert Email:");
                    String name = inLog.nextLine();
                    if (!Program.getInstance().checkEmail(name)) {
                        submit();
                    }
                    while (Program.getInstance().getCurrentUser() == null) {
                        System.out.println("Insert Password:");
                        String pass = inLog.nextLine();
                        Program.getInstance().login(name, encode(pass));
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

        Program.getInstance().setQuit(true);
    }

    public void submit() {
        Scanner inLog = new Scanner(System.in);
        System.out.println("REGISTRATION FORM");
        System.out.println("Are you a florist or a customer? ");
        String a = inLog.nextLine();
        String email = null;
        String name = null;
        String surname = null;
        String pass;
        String address = null;
        String encoded = null;

        switch (a) {

            case "florist":
                System.out.println("Insert Email: ");
                email = inLog.nextLine();
                System.out.println("Insert Name: ");
                name = inLog.nextLine();
                System.out.println("Insert Surname: ");
                surname = inLog.nextLine();
                System.out.println("Insert Address (optional): ");
                address = inLog.nextLine();
                System.out.println("Create a Password: ");
                pass = inLog.nextLine();
                encoded = encode(pass);
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
                System.out.println("Create a Password: ");
                pass = inLog.nextLine();
                encoded = encode(pass);
                break;

            default:
                System.err.println("You have to be either a florist or a customer.");

        }
        if (!Program.getInstance().checkEmail(email))
            Program.getInstance().signIn(a, email, name, surname, address, encoded);
    }

    private String encode(String password){
        md.update(password.getBytes());
        byte[] messageDigestSHA256 = md.digest();
        StringBuilder stringBuffer = new StringBuilder();
        for (byte bytes : messageDigestSHA256) {
            stringBuffer.append(String.format("%02x", bytes & 0xff));
        }
        return stringBuffer.toString();
    }
}