import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        //Program p = Program.getInstance();
        //p.run();

        //Scanner scan = new Scanner(new File("/home/beatrice/Scrivania/VICARIO/FlowerShop/usersdata.txt"));
        //while (scan.hasNextLine()) {
        //    String line = scan.nextLine();
        //    System.out.println(line);
        //}
        //String path = "/home/beatrice/Scrivania/VICARIO/FlowerShop/usersdata.txt";
        //PrintWriter pw = new PrintWriter(new FileWriter(path, true));
        //pw.append("\n");
        //pw.close();
/*
        String pathToCSV = "/home/beatrice/Scrivania/VICARIO/FlowerShop/users.csv";
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCSV));
        String row = csvReader.readLine();
        while ((row) != null) {
            String[] data = row.split(";");
            System.out.print(Arrays.toString(data) + "\n");
            row = csvReader.readLine();
        }
        csvReader.close();
*/
        String fileToUpdate = "/home/beatrice/Scrivania/VICARIO/FlowerShop/orders.csv";
        File inputFile = new File(fileToUpdate);

// Read existing file
        List<String[]> csvBody = null;
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(fileToUpdate));
            csvBody = reader.readAll();
        } catch (com.opencsv.exceptions.CsvException e) {
            System.err.println("ERROR: CSV EXCEPTION.");
        }
// get CSV row column and replace with by using row and column
        try {
            csvBody.get(0)[3] = "processing";
            reader.close();
        } catch (Exception e) {
            System.err.println("ERROR: csv exception");
        }

// Write to CSV file which is open
        CSVWriter writer = new CSVWriter(new FileWriter(inputFile));
        writer.writeAll(csvBody);
        writer.flush();
        writer.close();


    }
}