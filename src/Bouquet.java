import java.util.ArrayList;

public class Bouquet extends Product{
    private String name;
    private ArrayList<Product> childProduct = new ArrayList<>();

    //public Product composition;
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
