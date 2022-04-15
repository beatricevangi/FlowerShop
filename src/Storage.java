import java.util.ArrayList;

public class Storage implements Subject{
    private ArrayList<Pair<String, Integer>> quantity;
    private ArrayList<Pair<String, Boolean>> sufficient;
    public ArrayList<Observer> observers;
    //TODO array list mi raccomando
    int minimum = 15;

    @Override
    public void notify(Object obj){
        //TODO
    }

    @Override
    public void subscribe(Observer o){
        //TODO
    }

    @Override
    public void unsubscribe(Observer o) {
        //TODO
    }

}
