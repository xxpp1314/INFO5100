import java.util.Random;

public class BankAccount {
    private Object banklock = new Object();
    private int balance = 0;
    private String name;

    public BankAccount(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    public int getBalance(){
        synchronized (banklock){
            return balance;
        }
    }

    public int deposit(int amount) throws InterruptedException{
        synchronized (banklock){
            balance += amount;
            banklock.wait();
            return balance;
        }
    }

    public int withdraw(int amount) throws InterruptedException{
        synchronized (banklock){
            if(amount > balance){
                System.out.println("The balance is not enough, you can't withdoe corresponding money");
            }
            else{
                balance -= amount;
            }
            banklock.wait();
            return balance;
        }
    }

    public int generateRandomAmount() {
            Random random = new Random();
            int dollar = random.nextInt(100);
            return dollar;
    }


    public static void main(String[] args) {
        BankAccount one = new BankAccount("Oliver", 10);
        System.out.println(one);
        BankAccount two = new BankAccount("Rachel", 20);
        System.out.println(two);
        BankAccount three = new BankAccount("Lucky", 15);
        System.out.println(three);
        int maxBalance = 100;

        Thread t1 = new Thread(()->{
            try{
                while(one.balance < maxBalance){
                    one.getBalance();
                    one.deposit(one.generateRandomAmount());
                    one.withdraw(one.generateRandomAmount());
                    one.getBalance();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            try{
                while(two.balance < maxBalance){
                    two.getBalance();
                    two.deposit(two.generateRandomAmount());
                    two.withdraw(two.generateRandomAmount());
                    two.getBalance();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(()->{
            try{
                while(three.balance < maxBalance){
                    three.getBalance();
                    three.deposit(three.generateRandomAmount());
                    three.withdraw(three.generateRandomAmount());
                    three.getBalance();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
