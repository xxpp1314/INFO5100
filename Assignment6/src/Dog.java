import java.time.LocalDate;

public class Dog extends Pet implements Boardable{

    private String size;
    private LocalDate startDate;
    private LocalDate endDate;

    public Dog(String name, String ownerName, String color, String size){
        super(name, ownerName, color);
        this.size = size;
    }

    public String getSize(){
        return size;
    }

    public String toString(){
        return "DOG:\n"
                + getPetName() + " owned by " + getOwnerName() + "\n"
                + "Color:" + getColor() + "\n"
                + "Sex:" + getSex() + "\n"
                + "Size:" + getSize();
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        this.startDate = LocalDate.of(year, month, day);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        this.endDate = LocalDate.of(year, month, day);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        LocalDate realDate = LocalDate.of(year, month, day);
        if(realDate.isBefore(startDate) || realDate.isAfter(endDate))
            return false;
        return true;
    }
}
