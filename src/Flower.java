public class Flower extends Product{
    private String name;

    Flower(String name, float price){
        this.price = price;
        this.name = name;
    }

    String getName(){
        return name;
    }

    float getPrice(){
        return price;
    }

    @Override
    protected Flower clone(){
        Flower copy = new Flower(this.name, this.price);
        return copy;
    }
}
