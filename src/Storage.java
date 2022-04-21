import java.lang.reflect.Array;
import java.util.ArrayList;

public class Storage implements Subject{
    private ArrayList<Pair<String, Integer>> quantity;
    private ArrayList<Pair<String, Boolean>> sufficient;
    public ArrayList<Observer> observers;
    //TODO array list mi raccomando
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

    public Product getItem(){
        // questo metodo verrà chiamato dal Fioraio, che possiede uno storage
        return null;
    }
    //getFlowers

}
