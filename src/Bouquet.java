import java.util.ArrayList;
//con il composite potrei avere un Bouquet dato da un Bouquet e un fiore


public class Bouquet extends Product{
    private String name;
    private ArrayList<Product> childProduct;

    public void add(Product p) { }

    final Bouquet getComposite() { return this; }

    public Bouquet(String name) {
        this.name = name;
        this.childProduct = new ArrayList<>();
    }

    String getName(){
        return name;
    }
}
