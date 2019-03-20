public class Task1 implements Runnable {

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

    public static void main(String[] args) {
        Task1 run1 = new Task1();
        Task1 run2 = new Task1();
        Task1 run3 = new Task1();
        Task1 run4 = new Task1();
        Task1 run5 = new Task1();

        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);
        Thread t3 = new Thread(run3);
        Thread t4 = new Thread(run4);
        Thread t5 = new Thread(run5);

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
        
        double sum = run1.getData() + run2.getData() + run3.getData() + run4.getData() + run5.getData();

        System.out.printf("The sum is: %.2f ", sum);
    }
}