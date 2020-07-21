public class Goods {
    private int id;
    private String name, expirationDate;
    private double price;

    Goods(int id, String name, double price, String expirationDate){
        this.id = id;
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public double getPrice(){
        return price;
    }
    public String getName() {return name; }
    @Override
    public String toString() {
        return "Item id: " + id + " , Name: " + name + " , Price: " + price + " , Expiration Date: " + expirationDate;
    }
}
