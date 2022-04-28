import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Program {
    public static Program p = new Program();
    private final ArrayList<User> users;
    private User currentUser;
    private Menu menu;
    private boolean quit = false;

    private Program() {
        currentUser = null;
        users = new ArrayList<>();
        menu = new LoginMenu();
        initUsers();
        createCatalog();

    }

    public void initUsers() {
        String pathToCSV = "/home/beatrice/Scrivania/VICARIO/FlowerShop/users.csv";
        try {
            CSVReader reader = new CSVReader(new FileReader(pathToCSV));
            List<String[]> csvBody = reader.readAll();
            for (String[] strings : csvBody) {
                if (strings[0].equals("florist")) {
                    Florist f = new Florist(strings[1], strings[2], strings[3], strings[4], strings[5], false);
                    users.add(f);
                }
                if (strings[0].equals("customer")) {
                    Customer c = new Customer(strings[1], strings[2], strings[3], strings[4], strings[5], false);
                    users.add(c);
                }
            }

            reader.close();
        } catch (Exception e) {
            System.err.println("Error: init on Program while reading csv");
        }
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void createCatalog() {
        Catalog.getInstance();
    }

    public void run() {
        //todo sistema quit

        while (!quit) {
            menu.show();
        }
    }

    public void login(String email, String encoded) {
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                if (Objects.equals(u.getHashPass(), encoded)) {
                    System.out.println("Successfully logged in");
                    u.setLogged(true);
                    currentUser = getUser(email);
                } else {
                    System.out.println("Wrong password!");
                    currentUser = null;
                }
            }
        }
    }

    public void signIn(String category, String email, String name, String surname, String address, String encoded) {
        if (category.equals("customer")) {
            currentUser = new Customer(email, name, surname, address, encoded, true);
            users.add(currentUser);
        }
        if (category.equals("florist")) {
            currentUser = new Florist(email, name, surname, address, encoded, true);
            users.add(currentUser);
        }
        writeUserOnCSV(category, currentUser);
    }

/*
    public void writeOnFile(String category, String email, String name, String surname, String address, String encoded){
     String path = "/home/beatrice/Scrivania/VICARIO/FlowerShop/usersdata.txt";
     try{
     Scanner scan = new Scanner(new File(path));
         while (scan.hasNextLine()) {
             String line = scan.nextLine();
             System.out.println(line);
         }
     } catch (FileNotFoundException e){
         System.err.println("ERROR");
     }
     try {
         PrintWriter pw = new PrintWriter(path);
         pw.append("\n");
         pw.append(category+ "\n" + email + "\n" + name + "\n" + surname + "\n" + address + "\n" + encoded + "\n");
            pw.close();
        } catch (IOException e){
            System.err.println("ERROR");
        }
    }
*/

    public void writeUserOnCSV(String category, User currentUser) {
        String pathToCSV = "/home/beatrice/Scrivania/VICARIO/FlowerShop/users.csv";
        try {
            CSVReader reader = new CSVReader(new FileReader(pathToCSV));
            List<String[]> csvBody = reader.readAll();
            String[] newuser = {category, currentUser.getEmail(), currentUser.getName(), currentUser.getSurname(),
                    currentUser.getAddress(), currentUser.getHashPass(), String.valueOf(currentUser.getId())};
            csvBody.add(newuser);
            reader.close();

            CSVWriter writer = new CSVWriter(new FileWriter(pathToCSV));
            writer.writeAll(csvBody);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.err.println("Error: Csv Exception");
        }
    }

    public boolean checkEmail(String str) {
        for (User u : users) {
            if (u.getEmail().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static synchronized Program getInstance() {
        return p;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public User getUser(String email) {
        for (User u : users) {
            if (Objects.equals(u.getEmail(), email)) {
                return u;
            }
        }
        return null;
    }

    public Customer getCustomerFromId(int id) {
        for (User u : users) {
            if (u.getId() == id && u instanceof Customer) {
                return ((Customer) u);
            }
        }
        System.out.println("ID non-existent or non-belonging to a Customer.");
        return null;
    }

    public int getNumUsers() {
        return users.size();
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }
}
