public class ReverseHello implements Runnable {

    private int index;

    public ReverseHello(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println("Hello from Thread " + this.index + "!");
    }

    public static void main(String[] args) {
        for(int i = 50; i > 0; i--){
            Thread threadNum = new Thread(new ReverseHello(i));
            threadNum.start();
            try{
                threadNum.join();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

