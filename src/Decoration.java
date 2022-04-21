public class Decoration extends Product{
    private String name;

    Decoration(String name, float price){
        this.price = price;
        this.name = name;
    }

    String getName(){
        return name;
    }


    @Override
    protected Decoration clone(){
        Decoration copy = new Decoration(this.name, this.price);
        return copy;
    }
}
