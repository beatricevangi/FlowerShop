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

    public void addItem(Product p){
        childProduct.add(p);
    }

    @Override
    protected Bouquet clone(){
        Bouquet copy = new Bouquet(this.name);
        for (Product i : this.childProduct){
            //TODO rimaniamo a sentire frank i.clone();
        }
        return copy;
    }

}
