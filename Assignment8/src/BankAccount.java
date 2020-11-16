import java.util.Random;

public class BankAccount {
    private Object banklock = new Object();
    private int balance;
    private String name;
    //private int minBalance = 0;

    public BankAccount(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public int deposit(int amount) throws InterruptedException{
            balance += amount;
        return balance;
    }

    public int withdraw(int amount) throws InterruptedException{
            if(amount > balance)
                System.out.println("The balance is not enough, you can't withdoe corresponding money");
            else
                balance -= amount;

        return balance;
    }

    public int generateRandomAmount() {
        Random random = new Random();
        int dollar = random.nextInt();
        return dollar;
    }


    public static void main(String[] args) {
        BankAccount one = new BankAccount("Oliver", 50);
        System.out.println(one);
        BankAccount two = new BankAccount("Rachel", 100);
        System.out.println(two);
        BankAccount three = new BankAccount("Lucky", 99);
        System.out.println(three);
        int minBalance = 0;

        Thread t1 = new Thread(()->{
            while(one.balance < minBalance){
                one.getBalance();
                try {
                    one.deposit(one.generateRandomAmount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    one.withdraw(one.generateRandomAmount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                one.getBalance();
            }
        });

        Thread t2 = new Thread(()->{
            while(two.balance < minBalance){
                two.getBalance();
                try {
                    two.deposit(two.generateRandomAmount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    two.withdraw(two.generateRandomAmount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                two.getBalance();
            }
        });

        Thread t3 = new Thread(()->{
            while(three.balance < minBalance){
                three.getBalance();
                try {
                    three.deposit(three.generateRandomAmount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    three.withdraw(three.generateRandomAmount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                three.getBalance();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e ){
            e.printStackTrace();
        }

    }
}
