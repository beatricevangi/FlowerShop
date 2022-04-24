import java.util.ArrayList;

public class Supplier implements Observer{
    private ArrayList<Pair<Flower, Integer>> fcatalog; //catalogo di fiori
    private ArrayList<Pair<Decoration, Integer>> dcatalog; //catalogo di decorazioni
    //TODO: scegliere se catalogo arraylist di product con incremento del 50% del prezzo
    private Storage s = null;

    public Supplier(){}

    @Override
    public void update(Object str) {
        System.out.println("Carico in arrivoo!");
        sendItem(str);
    }
    //https://medium.datadriveninvestor.com/design-patterns-a-quick-guide-to-observer-pattern-d0622145d6c2
    //https://www.journaldev.com/1739/observer-design-pattern-in-java

    public void setSubject (Storage s) {
        if (s != null) {
            this.s.unsubscribe(this);
        }
        this.s = s;
        s.subscribe(this);
    }

    public void sendItem(String str) {
        // obj in realtà sarà una stringa che è il nome del fiore che mandiamo
        Catalog c = Catalog.getInstance();
        for (int tmp = 0; tmp < 100; tmp++) {
            Product p = c.cloneCatalogItem(str, false);
            p.setPrice(p.getPrice()/(float)0.35);
            s.restock(p);
        }
    }
}
