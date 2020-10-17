public class Cookie extends DessertItem{

    int number;
    int cents;
    public Cookie(String name, int number, int cents){
        this.name = name;
        this.number = number;
        this.cents = cents;
    }
    public int getCents(){
        return cents;
    }
    @Override
    public int getCost() {
        int cost = (int)Math.round(number * cents / 12);
        return cost;
    }
}
