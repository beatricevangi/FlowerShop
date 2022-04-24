import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


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
            if(i.getName() == name){
                storage.remove(i);
                refresh(i.getName(), "remove");
                return i;
            }
        }
        System.out.println("Non c'è nessun cazzetto qui, niente vigorsol :( ... ");
        return null;
    }

    public void refresh(String name, String flag){
        // metodo che aggiorna la lista che tiene conto delle quantità
        for(int i = 0; i < quantity.size(); i++ ){
            if (name == quantity.get(i).first){
                if(flag == "add")
                    quantity.get(i).second++;
                if(flag == "remove")
                    quantity.get(i).second--;
                if (quantity.get(i).second < minimum){
                    notify(quantity.get(i).first);
                }
            }
        }
    }
}
