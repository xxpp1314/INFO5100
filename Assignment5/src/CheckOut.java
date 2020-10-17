import java.util.ArrayList;
import java.util.List;

public class CheckOut {

    List<DessertItem> dessert;

    public CheckOut(){
        dessert = new ArrayList<>();
    }

    public int numberOfItems(){
        int number = dessert.size();
        return number;
    }

    public void enterItem(DessertItem item){
            dessert.add(item);
    }

    public void clear(){
        dessert.clear();
    }

    public int totalCost(){
        int curCost = 0;
        for(int i = 0; i < dessert.size(); i++){
            curCost += dessert.get(i).getCost();
        }
        return curCost;
    }

    public int totalTax(){
        DessertShoppe rate = new DessertShoppe();
        int finalTax = (int)Math.round(totalCost() * rate.taxRate);
        return finalTax;
    }

    public String toString(){

        DessertShoppe changeDollar = new DessertShoppe();
        System.out.println("M & M Dessert Shoppe" + "\n"
                         + "--------------------" + "\n");
        for(int i = 0; i < dessert.size(); i++){
            if(dessert.get(i) instanceof Candy)
                System.out.println(((Candy) dessert.get(i)).weight + " lbs. @ " + ((Candy) dessert.get(i)).price/100 + " /lb." + "\n"
                        + dessert.get(i).getName() + " " + changeDollar.cents2dollarsAndCents(dessert.get(i).getCost()));
            if(dessert.get(i) instanceof Cookie)
                System.out.println(((Cookie) dessert.get(i)).number + " @ " + (changeDollar.cents2dollarsAndCents(((Cookie) dessert.get(i)).getCents())) + " /dz." + "\n"
                        + dessert.get(i).getName() + " " + changeDollar.cents2dollarsAndCents(dessert.get(i).getCost()));
            if(dessert.get(i) instanceof Sundae)
                System.out.println(((Sundae) dessert.get(i)).getToppingName() + " Sundae with\n" + dessert.get(i).getName() + " " + changeDollar.cents2dollarsAndCents(dessert.get(i).getCost()));
            else if(dessert.get(i) instanceof IceCream)
                System.out.println(dessert.get(i).getName() + " " + changeDollar.cents2dollarsAndCents(dessert.get(i).getCost()));
        }
        return "Tax " + changeDollar.cents2dollarsAndCents(totalTax()) + "\n"
             + "Total Cost " + changeDollar.cents2dollarsAndCents(totalTax() + totalCost());
    }

}
