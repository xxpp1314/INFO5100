import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cat extends Pet implements Boardable{

    private String hairLength;
    private LocalDate startDate;
    private LocalDate endDate;

    public Cat(String name, String ownerName, String color, String hairLength){
        super(name, ownerName, color);
        this.hairLength = hairLength;
    }

    public String getHairLength(){
        return hairLength;
    }

    public String toString(){
        return "CAT:\n"
              + getPetName() + " owned by " + getOwnerName() + "\n"
              + "Color:" + getColor() + "\n"
              + "Sex:" + getSex() + "\n"
              + "Hair:" + getHairLength();
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
