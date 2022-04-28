import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;



public class main {
    public static void main(String[] args) throws IOException {
        Program p = Program.getInstance();
        p.run();

        //Scanner scan = new Scanner(new File("/home/beatrice/Scrivania/VICARIO/FlowerShop/usersdata.txt"));
        //while (scan.hasNextLine()) {
        //    String line = scan.nextLine();
        //    System.out.println(line);
        //}
        //String path = "/home/beatrice/Scrivania/VICARIO/FlowerShop/usersdata.txt";
        //PrintWriter pw = new PrintWriter(new FileWriter(path, true));
        //pw.append("\n");
        //pw.close();

        String pathToCSV = "/home/beatrice/Scrivania/VICARIO/FlowerShop/users.csv";
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCSV));
        String row = csvReader.readLine();
        while ((row) != null) {
            String[] data = row.split(";");
            System.out.print(Arrays.toString(data) + "\n");
            row = csvReader.readLine();
        }
        csvReader.close();



    }
}