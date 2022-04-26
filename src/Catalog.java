import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Catalog {
    private ArrayList<Product> floristcat = new ArrayList<Product>();
    private ArrayList<Product> suppliercat = new ArrayList<Product>();
    public static Catalog cat = new Catalog();


    Catalog() {
        Scanner scan = null;
        try {
            String fileFlower = "flower.txt";
            scan = new Scanner(new File(fileFlower));
            while (scan.hasNextLine()) {
                String line1 = scan.nextLine();
                System.out.println(line1);
                float line2 = scan.nextFloat();
                Flower f = new Flower(line1, line2);
                Flower f2 = new Flower(line1, line2 * (float) 0.35);
                addToFloristCatalog(f);
                addToSupplierCatalog(f2);
            }
            String fileDec = "decoration.txt";
            scan = new Scanner(new File(fileDec));
            while (scan.hasNextLine()) {
                String line1 = scan.nextLine();
                System.out.println(line1);
                float line2 = scan.nextFloat();
                Decoration d = new Decoration(line1, line2);
                Decoration d2 = new Decoration(line1, line2 * (float) 0.35);
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
        } finally {
            if (scan != null)
                scan.close();
        }

    }

    public void addBouquetToCatalog(String s) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(s));
        String firstline = scan.nextLine();
        Bouquet b = new Bouquet(firstline);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Product item = cloneCatalogItem(line, true);
            b.addItem(item);
        }
        addToFloristCatalog(b);
    }

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
        int i = 1;
        for (Product item : floristcat) {
            System.out.println(i + ":");
            item.display();
            System.out.println("\n");
            i++;
        }
    }

    public void displaySupplierCatalog() {
        for (Product item : suppliercat) {
            item.display();
        }
    }

    public Product cloneCatalogItem(String s, boolean floristcat) {
        Product copy = null;
        ArrayList<Product> list;
        if (floristcat) {
            list = this.floristcat;
        } else {
            list = this.suppliercat;
        }
        for (Product p : list) {
            if (Objects.equals(p.getName(), s)) {
                if (p instanceof Flower) {
                    copy = ((Flower) p).clone();
                } else {
                    if (p instanceof Decoration) {
                        copy = ((Decoration) p).clone();
                    }
                }
            }
        }
        return copy;
    }

    public Product getFloristProduct(int num) {
        return floristcat.get(num - 1);
    }

    public Product getSupplierProduct(int num) {
        return suppliercat.get(num - 1);
    }
}
