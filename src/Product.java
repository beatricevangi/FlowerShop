public abstract class Product {
    protected float price;
    protected String name;

    Bouquet getComposite() { return (Bouquet) this; }

    public void display() {
        System.out.println("Article: " + name + " Price: " + price);
    }
}
