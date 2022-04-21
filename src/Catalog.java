import java.util.ArrayList;

// TODO È UN SINGLETON
public class Catalog {
    private ArrayList<Product> c = new ArrayList<>();

    public static Catalog cat = new Catalog();

    public static Catalog getInstance(){
        return cat;
    }

    public void addToCatalog(Product p){
        c.add(p);
    }

    public void displayCatalog(){
        System.out.println(c);
    }
}
