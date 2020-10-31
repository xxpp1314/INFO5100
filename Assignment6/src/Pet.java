public class Pet {
    private String name;
    private String ownerName;
    private String color;
    protected int sex;

    public static final int Male = 0;
    public static final int Female = 1;
    public static final int Spayed = 2;
    public static final int Neutered = 3;

    public Pet(String name, String ownerName, String color){
        this.name = name;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String getPetName(){
        return name;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public String getColor(){
        return color;
    }

    public void setSex(int sexid){
        this.sex = sexid;
    }

    public String getSex(){
        if(this.sex == 0)
            return "Male";
        else if(this.sex == 1)
            return "Female";
        else if(this.sex == 2)
            return "Spayed";
        else if(this.sex == 3)
            return "Neutered";
        return null;
    }

    public String toString(){
        return getPetName() + " owned by " + getOwnerName() + "\n"
             + getColor() + "\n"
             + getSex();
    }
}


