import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Storage implements Subject{
    private ArrayList<Pair<String, Integer>> quantity;
    public ArrayList<Observer> observers;
    private ArrayList<Product> storage;
    int minimum = 15;

    public Storage(){
        quantity = new ArrayList<>();
        storage = new ArrayList<>();
        observers = new ArrayList<>();
        initObs();
        initStorage();
        checkQuantity();
    }

    public void initStorage(){
        String pathToCSV = "storage.csv";
        try {
            CSVReader reader = new CSVReader(new FileReader(pathToCSV));
            List<String[]> csvBody = reader.readAll();
            for (String[] strings : csvBody) {
                Pair pair = new Pair(strings[0], Integer.parseInt(strings[1]));
                quantity.add(pair);
                for(int i = 0; i < Integer.parseInt(strings[1]); i++){
                    Product p = Catalog.getInstance().cloneCatalogItem(strings[0], true);
                    storage.add(p);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error: init on Storage while reading csv.");
        }
    }

    public void initObs(){
        Supplier supp = new Supplier(this);
    }


    @Override
    public void notify(Object name){
        for(Observer o : observers){
            o.update(name);
        }
    }

    @Override
    public void subscribe(Observer o){
        observers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    public void restock(Product p){
        storage.add(p);
        refresh(p.getName(), "add");
    }

    public Product getItem(String name){
        //chiamato da fioraio per prendere imgridietnz
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println("Error: interrupted exception");
        }
        for (Product i : storage){
            if(i.getName().equals(name)){
                storage.remove(i);
                refresh(i.getName(), "remove");
                checkQuantity();
                return i;
            }
        }
        System.out.println("Non c'è nessun fio :( ... ");
        return null;
    }

    public void refresh(String name, String flag){
        // metodo che aggiorna la lista che tiene conto delle quantità
        for (Pair<String, Integer> stringIntegerPair : quantity) {
            if (name.equals(stringIntegerPair.first)) {
                if (flag.equals("add")){
                    stringIntegerPair.second++;
                    refreshCSV(name, stringIntegerPair.second);
                }
                if (flag.equals("remove")){
                    stringIntegerPair.second--;
                    refreshCSV(name, stringIntegerPair.second);
                }
            }
        }
    }

    public void refreshCSV(String str, int q){
        String pathToCSV = "storage.csv";
        File inputFile = new File(pathToCSV);
        try {
            CSVReader reader = new CSVReader(new FileReader(pathToCSV));
            List<String[]> csvBody = reader.readAll();
            for (String[] strings : csvBody) {
                if(strings[0].equals(str)){
                    strings[1] = String.valueOf(q);
                }
            }
            reader.close();
            CSVWriter writer = new CSVWriter(new FileWriter(inputFile));
            writer.writeAll(csvBody);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.err.println("ERROR: Storage Csv Exception.");
        }
    }

    public void checkQuantity() {
        String str = "";
        for (Pair<String, Integer> stringIntegerPair : quantity) {
            if (stringIntegerPair.second < minimum) {
                notify(stringIntegerPair.first);
                str = str + stringIntegerPair.first + "\n";
            }
        }
        if(!str.equals("")) {
            System.out.println("Storage updated. Items added: \n" + str);
        }
    }

    public void display(){
        System.out.println("\n");
        System.out.println("Storage items: ");
        for (Pair<String, Integer> stringIntegerPair : quantity) {
            System.out.println("-" + stringIntegerPair.first + "          " + stringIntegerPair.second);
        }
    }
}
