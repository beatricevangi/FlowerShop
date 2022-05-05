public abstract class Product {
    protected float price;
    protected String name;

    Bouquet getComposite() { return (Bouquet) this; }

    protected abstract Product clone();


    public String getName() {
        return name;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void display() {
        String str = String.format("%.02f", price);
        System.out.println("Article: " + name + "                    Price: " + str + "€");
    }

}