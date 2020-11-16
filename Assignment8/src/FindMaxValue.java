import java.util.Random;

public class FindMaxValue {

    private static long maxValue = 0;

    static void generateRandomArray(int[] arr) {
        if (arr.length == 0)
            return;
        Random random = new Random();
        int a = random.nextInt();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a;
        }
    }

    static long getMaxValue(int[] arr) throws InterruptedException {
        Thread t1 = new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr.length / 4; i++) {
                    if(arr[i] > maxValue)
                        maxValue = arr[i];
                }
            }
        }));
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = arr.length / 4; i >= arr.length / 4 && i < arr.length / 2; i++) {
                    if(arr[i] > maxValue)
                        maxValue = arr[i];
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = arr.length / 2; i >= arr.length / 2 && i < arr.length / 4 * 3; i++) {
                    if(arr[i] > maxValue)
                        maxValue = arr[i];
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = arr.length / 4 * 3; i >= arr.length / 4 * 3 && i < arr.length; i++) {
                    if(arr[i] > maxValue)
                        maxValue = arr[i];
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

        return maxValue;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[4000000];
        generateRandomArray(arr);;
        long maxValue = getMaxValue(arr);
        System.out.println("The maxValue is " + maxValue);
    }
}