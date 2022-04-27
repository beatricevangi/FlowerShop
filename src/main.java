import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Program p = new Program();
        p.run();
        File f = new File("UsersData.txt");
        if (f.exists()){
            System.out.println("weeeeeee");
        }
        FileWriter fw = new FileWriter(f);
        fw.append("eddaeeei \n");
        fw.append("seconda riga");

        //Scanner scan = new Scanner(new File("/home/beatrice/Scrivania/VICARIO/FlowerShop/usersdata.txt"));
        //while (scan.hasNextLine()) {
        //    String line = scan.nextLine();
        //    System.out.println(line);
        //}
        //String path = "/home/beatrice/Scrivania/VICARIO/FlowerShop/usersdata.txt";
        //PrintWriter pw = new PrintWriter(new FileWriter(path, true));
        //pw.append("\n");
        //pw.close();



    }
}