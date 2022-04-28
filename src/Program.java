import java.io.*;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
    private OrderList ol = OrderList.getInstance();
    public static Program p = new Program();
    private final ArrayList<User> users;
    private User currentUser;
    private Menu menu;
    private boolean quit = false;

    private Program(){
        currentUser = null;
        users = new ArrayList<User>();
        //menu = new LoginMenu();

        //createCatalog();
        init();

    }

    public void init(){
        String pathToCSV = "/home/beatrice/Scrivania/VICARIO/FlowerShop/users.csv";
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(pathToCSV));
            String row = csvReader.readLine();
            while ((row) != null) {
                String[] data = row.split(";");
                if (data[0] == "florist") {
                    Florist f = new Florist(data[1], data[2], data[3], data[4], data[5], false);
                    users.add(f);
                }
                if (data[0] == "customer") {
                    Customer c = new Customer(data[1], data[2], data[3], data[4], data[5], false);
                    users.add(c);
                }
                row = csvReader.readLine();
            }
            csvReader.close();
        } catch (IOException e) {
            System.err.println("Error");
        }
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void createCatalog(){
        Catalog c = new Catalog();
    }

    public void run(){
        //todo sistema quit

       //while(!quit){
       //    menu.show();
       //}
    }


    public void login(String email, String encoded){
        for(User u : users){
            if(u.getEmail() == email){
                if(u.getHashPass() == encoded){
                    System.out.println("Successfully logged in");
                    u.setLogged(true);
                    currentUser = getUser(email);
                }
                else{
                    System.out.println("Wrong password!");
                    currentUser = null;
                }
            }
        }
    }

    public void signIn(String category, String email, String name, String surname, String address, String encoded){
        if (category == "customer"){
            currentUser = new Customer(email, name, surname, address, encoded, true);
            users.add(currentUser);
        }
        if(category == "florist"){
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


    public void writeUserOnCSV(String category, User currentUser){
        String pathToCSV = "/home/beatrice/Scrivania/VICARIO/FlowerShop/users.csv";
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(pathToCSV, true));
        } catch (IOException e) {
            System.err.println("Error");
        }
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append(category + ";" + currentUser.getEmail() + ";" + currentUser.getName() + ";" + currentUser.getSurname()
                + ";" + currentUser.getAddress() + ";" + currentUser.getHashPass() + ";" + currentUser.getId());
        pw.write(builder.toString());
        pw.close();
    }




    public boolean checkEmail(String str){
        for(User u : users){
            if(u.getEmail() == str){
                return true;
            }
        }
        return false;
    }

    public static synchronized Program getInstance(){
        return p;
    }


    public User getCurrentUser() {
        return currentUser;
    }

    public User getUser(String email){
        for(User u : users){
            if(u.getEmail() == email){
                return u;
            }
        }
        return null;
    }

    public int getNumUsers(){
        return users.size();
    }
}
