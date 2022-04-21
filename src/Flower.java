public class Flower extends Product {
    private String name;

    Flower(String name, float price) {
        this.price = price;
        this.name = name;
    }

    @Override
    protected Flower clone() {
        Flower copy = new Flower(new String(this.name), new Float(this.price));
        return copy;
    }
}
