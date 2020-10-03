import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Student a = new Student("Yinxing", 123);
        Student b = new Student("Rachel", 456);
        Course one = new Course("INFO5100", 9);
        System.out.println("Does INFO5100 is full? " + one.isFull());
        one.registerStudent(a);
        one.registerStudent(b);
        System.out.println("The first registered student's name is "  + one.getStudents().get(0).name);
        System.out.println("The first registered student's name is "  + one.getStudents().get(0).nuid);
        System.out.println("The second registered student's name is "  + one.getStudents().get(1).name);
        System.out.println("The second registered student's name is "  + one.getStudents().get(1).nuid);
    }
}

class Student{
        String name;
    int nuid;
    public Student(String name, int nuid){
        this.name = name;
        this.nuid = nuid;
    }
    public String getName(){
        return this.name;
    }
    public int getNuid(){
        return this.nuid;
    }
    public void setName(){
        this.name = name;
    }
    public void setNuid(){
        this.nuid = nuid;
    }
}

class Course {
    String name;
    int numberOfStudent;
    List<Student> curStudent;

    public Course(String name, int numberOfStudent) {
        this.name = name;
        this.numberOfStudent = numberOfStudent;
        curStudent = new LinkedList<>();
        this.curStudent = curStudent;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfStudent() {
        return this.numberOfStudent;
    }

    public void setName() {
        this.name = name;
    }

    public void setNumberOfStudent() {
        this.numberOfStudent = numberOfStudent;
    }
    public List<Student> getStudents(){
        return curStudent;
    }
    public boolean isFull(){
        if(numberOfStudent >= 10)
            return true;
        else
            return false;
    }
    public void registerStudent(Student student){
        if(numberOfStudent < 10)
            curStudent.add(student);
    }
}
