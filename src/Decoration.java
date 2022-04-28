public class Decoration extends Product{
    private String name;

    Decoration(String name, float price){
        this.price = price;
        this.name = name;
    }

    @Override
    protected Decoration clone(){
        return new Decoration(new String(this.name), this.price);
    }
}
