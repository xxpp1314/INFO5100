class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month

    // Constructor. Please set all the data in constructor.
    public Employee(String name, int age, Gender gender, double salary) {
        //write your code here
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;

    }

    // Getter for `name`. Return the current `name` data
    public String getName() {
        //write your code here;
        return this.name;
    }

    // Setter for `name`. Set `name` data
    public void setName(String name) {
        //write your code here
        this.name = name;
    }
    public void raiseSalary(double byPercent){
        this.salary = byPercent * this.salary ;
        System.out.println(this.salary);
    }
}

enum Gender {
    MALE,
    FEMALE;
}

public class EmployeeSalaryCalculate {
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public double socialSecurityTax(Employee employee) {
        //write your code here
        double tax = 0;
        if (employee.salary <= 8900)
            tax = 0.062 * employee.salary;
        else
            tax = 0.062 * 106800;
        System.out.println(tax);
        return tax;
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) {
        //write your code here
        double coverage = 0;
        if (employee.age < 35)
            coverage = employee.salary * 0.03;
        else if (employee.age >= 35 && employee.age <= 50)
            coverage = employee.salary * 0.04;
        else if (employee.age > 50 && employee.age < 60)
            coverage = employee.salary * 0.05;
        else
            coverage = employee.salary * 0.06;
        System.out.println(coverage);
        return coverage;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) {
        //write your code here
        String[] sort = new String[3];
        if (e1.salary < e2.salary && e1.salary < e3.salary) {
            sort[0] = e1.name;
            if (e2.salary > e3.salary) {
                sort[1] = e3.name;
                sort[2] = e2.name;
            } else {
                sort[1] = e2.name;
                sort[2] = e3.name;
            }
        } else if (e1.salary > e2.salary && e1.salary < e3.salary) {
            sort[3] = e3.name;
            if(e2.salary < e1.salary){
                sort[0] = e2.name;
                sort[1] = e1.name;
            }
            else{
                sort[0] = e1.name;
                sort[1] = e2.name;
            }
            // 1 2 3     1  3 2    3 1 2     2 3 1   213 3 2 1
        } else if (e1.salary > e2.salary && e1.salary > e3.salary) {
            sort[2] = e1.name;
            if (e2.salary > e3.salary) {
                sort[0] = e3.name;
                sort[1] = e2.name;
            } else {
                sort[0] = e2.name;
                sort[1] = e3.name;
            }
        }
        System.out.println("Salary Sort: " + sort);
    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {
        //write your code here
     //   double highSalary = employee.salary * 3;
        employee.raiseSalary(3.0);
    }

    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     My Understanding of this swap failed:
     There exists some differences between C++ and Java. In C++, the swap function can
     be implemented using Pointers or references. However, in Java, pointer variables
     cannot be operated directly and data types such as int, double, float and so forth,
     all of them are using values to pass parameters. In other words, what is passed into
     the function is only a copy of the original reference. In fact, the passing of an object
     is the passing of a reference copy, and changing the value in a function
     does not accomplish the purpose of the swapping. This is to say, what is swapped
     in a function is a copy and does not achieve the purpose of swapping.
    */
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
}
