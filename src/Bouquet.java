import java.util.ArrayList;

public class Bouquet extends Product{
    private String name;
    private ArrayList<Flower> flowers = new ArrayList<>();
    public Product composition;
    String getName(){
        return name;
    }
}
