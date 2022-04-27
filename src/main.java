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

        String path = "/home/beatrice/Scrivania/VICARIO/FlowerShop/UsersData.txt";
        Scanner scan = new Scanner(new File("UsersData.txt"));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            System.out.println(line);
        }

        // FileWriter w = new FileWriter("UsersData.txt");
        //String str = "seconda riga ";
        //w.write(str + "\n" + str + "\n");
        fw.close();
    }
}