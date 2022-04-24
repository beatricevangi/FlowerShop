import java.util.ArrayList;

public class Supplier implements Observer {
    private Storage s = null;

    public Supplier(Storage s) {
        this.s = s;
    }

    @Override
    public void update(Object str) {
        System.out.println("Carico in arrivoo!");
        sendItem((String)str);
    }
    //https://medium.datadriveninvestor.com/design-patterns-a-quick-guide-to-observer-pattern-d0622145d6c2
    //https://www.journaldev.com/1739/observer-design-pattern-in-java

    public void setSubject(Storage s) {
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
