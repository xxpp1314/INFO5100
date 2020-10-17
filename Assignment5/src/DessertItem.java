public abstract class DessertItem {
    String name;
    int cost;

    public DessertItem(){

    }

    public DessertItem(String name){
        this.name = name;
    }

    public final String getName(){
        return name;
    }

    public abstract int getCost();


}


