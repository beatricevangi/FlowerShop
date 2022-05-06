package Main;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class Message {
    private String heading;
    private String text;
    private boolean read;
    private Customer c;

    public Message(Customer c, String heading, String text) { // costruttore per creare nuovi messaggi da 0
        this.heading = heading;
        this.text = text;
        this.read = false;
        this.c = c;
        writeMessageOnCSV(true);
    }

    public Message(Customer c, String heading, String text, boolean read) { // costruttore per leggere (init)
        this.c = c;
        this.heading = heading;
        this.text = text;
        this.read = read;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public void display() {
        System.out.println(heading);
        System.out.println(text + "\n");
        setRead(true);
    }

    public void writeMessageOnCSV(boolean flag) {
        String pathToCSV = "messages.csv";
        try {
            CSVReader reader = new CSVReader(new FileReader(pathToCSV));
            List<String[]> csvBody = reader.readAll();
            if (flag) {
                String[] newmessage = {String.valueOf(this.c.getId()), this.heading, this.text, String.valueOf(this.read)};
                csvBody.add(newmessage);
            } else {
                csvBody.removeIf(strings -> this.c.getId() == Integer.parseInt(strings[0]));
            }
            reader.close();

            CSVWriter writer = new CSVWriter(new FileWriter(pathToCSV));
            writer.writeAll(csvBody);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.err.println("Error: Csv Message Exception.");
        }
    }
}