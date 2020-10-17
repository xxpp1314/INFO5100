public class Sundae extends IceCream{

    String toppingName;
    int toppingCents;

    public Sundae(String name, int cents, String toppingName, int toppingCents) {
        super(name, cents);
        this.toppingName = toppingName;
        this.toppingCents = toppingCents;
    }

    public void setToppingName(){
        this.toppingName = toppingName;
    }

    public String getToppingName(){
        return toppingName;
    }

    public void setToppingCents(){
        this.toppingCents = toppingCents;
    }

    public int getToppingCents(){
        return toppingCents;
    }

   @Override
    public int getCost() {
        int cost = super.getCost() + toppingCents;
        return cost;
    }
}
