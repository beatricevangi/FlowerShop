import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Storage implements Subject{
    private ArrayList<Pair<String, Integer>> quantity = new ArrayList<>();
    public ArrayList<Observer> observers;
    private ArrayList<Product> storage;
    int minimum = 15;

    public Storage(){
        for (String s : Arrays.asList("tulip", "peony", "laurel", "gardenia", "lily", "rose")) {
            quantity.add(new Pair<>(s, 0));
            refresh(s, " ");
        }
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
                if (flag.equals("remove"))
                    stringIntegerPair.second--;
                if (stringIntegerPair.second < minimum) {
                    notify(stringIntegerPair.first);
                }
            }
        }
    }
}
