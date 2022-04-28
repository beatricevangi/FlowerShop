public class Flower extends Product {
    private final String name;

    Flower(String name, float price) {
        this.price = price;
        this.name = name;
    }

    @Override
    protected Flower clone() {
        return new Flower(this.name, new Float(this.price));
    }
}
