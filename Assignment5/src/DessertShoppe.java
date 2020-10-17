public class DessertShoppe {

    final double taxRate = 0.065;
    final int maxItemSize = 100;
    final int widthOfCost = 100;

    public String cents2dollarsAndCents(int cents){
        double i = (double)cents/100;
        String dollar = i + "";
        return dollar;
    }


}
