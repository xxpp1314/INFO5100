import java.util.Random;

public class SumValue {

    private static long totalSum = 0;
    private static long sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;

    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr) {
        if (arr.length == 0)
            return;
        Random random = new Random();
        int a = random.nextInt();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a;
        }
    }

    /*get sum of an array using 4 threads*/
    static long sum(int[] arr) throws InterruptedException {
        Thread t1 = new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr.length / 4; i++) {
                    sum1 = sum1 + arr[i];
                }
            }
        }));
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = arr.length / 4; i >= arr.length / 4 && i < arr.length / 2; i++) {
                    sum2 = sum2 + arr[i];
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = arr.length / 2; i >= arr.length / 2 && i < arr.length / 4 * 3; i++) {
                    sum3 = sum3 + arr[i];
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = arr.length / 4 * 3; i >= arr.length / 4 * 3 && i < arr.length; i++) {
                    sum4 = sum4 + arr[i];
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        totalSum = sum1 + sum2 + sum3 + sum4;
        return totalSum;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[4000000];
        generateRandomArray(arr);;
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
    }
}