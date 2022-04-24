import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Catalog {
    private ArrayList<Product> floristcat = new ArrayList<Product>();
    private ArrayList<Product> suppliercat = new ArrayList<Product>();

    Catalog() {
        try {
            String fileFlower = "flower.txt";
            Scanner scan = new Scanner(new File(fileFlower));
            while (scan.hasNextLine()) {
                String line1 = scan.nextLine();
                System.out.println(line1);
                Float line2 = scan.nextFloat();
                Flower f = new Flower(line1, line2);
                Flower f2 = new Flower(line1, line2*(float)0.35);
                addToFloristCatalog(f);
                addToSupplierCatalog(f2);
            }
            String fileDec = "decoration.txt";
            scan = new Scanner(new File(fileDec));
            while (scan.hasNextLine()) {
                String line1 = scan.nextLine();
                System.out.println(line1);
                Float line2 = scan.nextFloat();
                Decoration d = new Decoration(line1, line2);
                Decoration d2 = new Decoration(line1, line2*(float)0.35);
                addToFloristCatalog(d);
                addToSupplierCatalog(d2);
            }
            addBouquetToCatalog("rustic.txt");
            addBouquetToCatalog("wedding.txt");
            addBouquetToCatalog("graduation.txt");
            addBouquetToCatalog("classic.txt");
            addBouquetToCatalog("funeral.txt");
            addBouquetToCatalog("valentine.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBouquetToCatalog(String s) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(s));
        String firstline = scan.nextLine();
        Bouquet b = new Bouquet(firstline);
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            Product item = cloneCatalogItem(line);
            b.addItem(item);
        }
        addToFloristCatalog(b);
    }

    public static Catalog cat = new Catalog();

    public static Catalog getInstance() {
        return cat;
    }

    public void addToFloristCatalog(Product p) {
        floristcat.add(p);
    }

    public void addToSupplierCatalog(Product p) {
        suppliercat.add(p);
    }

    public void displayFloristCatalog() {
        for (Product item : floristcat) {
            item.display();
        }
    }

    public void displaySupplierCatalog() {
        for (Product item : suppliercat) {
            item.display();
        }
    }

    public Product cloneCatalogItem(String s){
        Product c = null;
        for(Product p : floristcat){
            if(p.getName() == s){
                if(p instanceof Flower){
                    c = ((Flower) p).clone();
                }
                if(p instanceof Decoration){
                    c = ((Decoration) p).clone();
                }
                else {
                    c = ((Bouquet) p).clone();
                }
            }
        }
        return c;
    }

    public Product getFloristProduct(int num) {
        return floristcat.get(num - 1);
    }

    public Product getSupplierProduct(int num) {
        return suppliercat.get(num - 1);
    }
}
