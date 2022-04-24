import java.util.ArrayList;
import java.io.*;
import java.util.*;

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

    public void addToSupplierCatalog(Product p) {
        suppliercat.add(p);
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
