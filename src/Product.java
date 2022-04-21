public abstract class Product {
    protected float price;

    protected String name;

    Bouquet getComposite() { return (Bouquet) this; }

    //protected Product clone(){
    //  TODO
    // }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void display() {
        System.out.println("Article: " + name + " Price: " + price);
    }
}
