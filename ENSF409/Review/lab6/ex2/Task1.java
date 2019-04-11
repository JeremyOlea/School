public class Task1 implements Runnable{
    
    private double data;

    public void run() {
        RandomGenerator rand = new RandomGenerator();
        data = rand.randomNum();
    }

    public Task1() {
        data = 0;
    }

    public double getData() {
        return this.data;
    }

    public static void main(String args) {
        Task1 r1 = new Task1();
        Task1 r2 = new Task1();
        Task1 r3 = new Task1();
        Task1 r4 = new Task1();
        Task1 r5 = new Task1();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        Thread t5 = new Thread(r5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch(InterruptedException e) {
            e.getMessage();
        }

        double sum = r1.getData() + r2.getData() + r3.getData() + r4.getData() + r5.getData();

        System.out.printf("The sum is: %.2f ", sum);
    }
}