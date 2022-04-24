import java.lang.reflect.Array;
import java.util.ArrayList;

public class Storage implements Subject{
    private ArrayList<Pair<String, Integer>> quantity;
    //private ArrayList<Pair<String, Boolean>> sufficient;
    public ArrayList<Observer> observers;
    private ArrayList<Product> storage;
    int minimum = 15;

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

    public void getSuppProducts(ArrayList<Flower> f){
        //TODO
    }

    public void restock(Product p){
        //TODO: se si vuole fare incremento va fatto qui

        storage.add(p);
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
        System.out.println("Non c'è nessun cazzo qua");
        return null;
    }

    public void refresh(String name){
        for(int i = 0; i < quantity.size(); i++ ){
            if (name == quantity.get(i).first){
                quantity.get(i).second--;
                if (quantity.get(i).second < minimum){
                    notify(quantity.get(i).first);
                }
            }
        }
    }
}
