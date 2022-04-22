import java.util.ArrayList;

public class Catalog {
    private ArrayList<Product> floristcat = new ArrayList<Product>();
    private ArrayList<Product> suppliercat = new ArrayList<Product>();

    Catalog(){
        //TODO
    }

    public static Catalog cat = new Catalog();

    public static Catalog getInstance(){
        return cat;
    }

    public void addToCatalog(Product p){
        c.add(p);
    }

    public void displayCatalog(){
        for (Product item : c){
            item.display();
        }
    }

    public Product getProduct(int num){
        return c.get(num - 1);
    }
}
