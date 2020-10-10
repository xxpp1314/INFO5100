import java.lang.Math;

public class TestCylinder {
    public static void main(String[] args){
        //Constructed a Circle with Circle()
        //Run of the program should produce the following output:
        //Radius is 2.0, Color is yellow, Base area is (your answer)
        Circle one = new Circle();
        one.setRadius(2.0);
        one.setColor("yellow");
        System.out.println("Radius is " + one.radius + ", "
                         + "Color is " + one.color + ", "
                         + "Base area is " + one.getArea());

        //Constructed a Cylinder with Cylinder()
        //Run of the program should produce the following output:
        //Radius is 1.0, Height is 1.0, Color is red, Base area is (your answer), Volume is (your answer)
        Cylinder two = new Cylinder();
        System.out.println("Radius is " + two.radius + ", "
                         + "Color is " + two.color + ", "
                         + "Base area is " + two.getArea());

        //Constructed a Cylinder with Cylinder(height, radius)
        //Run of the program should produce the following output:
        //Radius is 2.0, Height is 5.0, Color is red, Base area is (your answer), Volume is (your answer)
        Cylinder three = new Cylinder(5.0, 2.0);
        System.out.println("Radius is " + three.radius + ", "
                         + "Height is " + three.height + ", "
                         + "Color is " + three.color + ", "
                         + "Base area is " + three.getArea() + ", "
                         + "Volume is " + three.getVolume());
    }
}

class Circle{
    double radius = 1.0;
    String color = "red";

    public Circle(){
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }
}

class Cylinder extends Circle{
    double height = 1.0;

    public Cylinder() {
        super();
    }

    public Cylinder(double height){
        this.height = height;
    }

    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    public  Cylinder(double height, double radius, String color){
        this.height = height;
        this.radius = radius;
        this.color = color;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        double volume = super.getArea() * height;
        return volume;
    }

    @Override
    public double getArea() {
        double area = 2 * Math.PI * radius * (radius + height);
        return area;
    }
}
