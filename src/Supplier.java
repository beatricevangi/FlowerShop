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

    public void sendItem(Object obj){
        Flower f = null;
        Decoration d = null;
        //TODO:una volta sistemato il catalogo o arrayList procedere a controllare i nomi e clonare
        if(obj.getClass().getName() == f.getClass().getName()){
            ArrayList<Flower> flowers = null;
            for(int tmp = 0; tmp<100; tmp++) {
                f = ((Flower)obj).clone();
                flowers.add(f);
            }
        }
        if(obj.getClass().getName() == d.getClass().getName()) {
            ArrayList<Decoration> decorations = null;
            for (int tmp = 0; tmp < 100; tmp++) {
                d = ((Decoration) obj).clone();
                decorations.add(d);
            }
        }
        s.getSuppProducts();
    }
}
