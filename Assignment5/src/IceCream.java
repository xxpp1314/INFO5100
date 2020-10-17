public class IceCream extends DessertItem{

    int cents;
    public IceCream(String name, int cents){
        this.name = name;
        this.cents = cents;
    }

    @Override
    public int getCost() {
        int cost = cents;
        return cost;
    }
}
