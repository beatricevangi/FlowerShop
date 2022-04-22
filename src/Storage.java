import java.lang.reflect.Array;
import java.util.ArrayList;

public class Storage implements Subject{
    private ArrayList<Pair<String, Integer>> quantity;
    private ArrayList<Pair<String, Boolean>> sufficient;
    public ArrayList<Observer> observers;
    private ArrayList<Product> storage;
    int minimum = 15;

    @Override
    public void notify(Object obj){
        for(Observer o : observers){
            o.update(obj);
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

    public void getSuppFlowers(ArrayList<Flower> f){
        //TODO
    }

    public void getSuppDecoration(ArrayList<Decoration> d){
        //TODO
    }

    public Product getItem(String name){
        for (Product i : storage){
            if(i.getName() == name){
                storage.remove(i);
                refresh(i.getName());
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
                //TODO notify!!!
            }
        }
    }
}
