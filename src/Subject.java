import java.util.List;

public interface Subject {
   // public void notify(Object obj)
    void notify(Object obj);
    void subscribe(Observer o);
    void unsubscribe(Observer o);
}
