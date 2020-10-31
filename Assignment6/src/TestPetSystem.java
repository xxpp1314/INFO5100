public class TestPetSystem {
    public static void main(String[] args){
        Pet one = new Pet("Spot", "Mary", "Black and White");
        one.setSex(0);
        System.out.println(one);

        Cat two = new Cat("Tom", "Bob", "Black", "Short");
        two.setSex(2);
        two.setBoardStart(4, 20,2019);
        two.setBoardEnd(5,21,2019);
        System.out.println(two);
        System.out.println(two.boarding(4,20,2019));
        System.out.println(two.boarding(5,21,2019));

        Dog three = new Dog("Spot", "Susan", "White", "Medium");
        three.setSex(2);
        three.setBoardStart(4, 20,2019);
        three.setBoardEnd(5,21,2020);
        System.out.println(three);
        System.out.println(three.boarding(12,31,2019));
        System.out.println(three.boarding(6,29,2020));
    }
}
