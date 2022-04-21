import java.util.ArrayList;

// TODO È UN SINGLETON
public class Catalog {
    private ArrayList<Product> c = new ArrayList<>();

    public static Catalog cat = new Catalog();

    public static Catalog getInstance(){
        return cat;
    }

    public void addToCatalog(){
        //TODO
    }

    public void displayCatalog(){
        //TODO
    }
}
