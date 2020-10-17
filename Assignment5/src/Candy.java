public class Candy extends DessertItem{

    double weight;
    double price;

    public Candy(String name, double weight, double price){
        this.name = name;
        this.weight = weight;
        this.price = price;
    }
    @Override
    public int getCost() {
        int cost = (int)Math.round(weight * price);
        return cost;
    }
}

