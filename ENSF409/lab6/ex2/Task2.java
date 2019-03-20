import java.util.*;

public class Task2 implements Runnable {

    private ArrayList<Double> data;

    synchronized public void run() {
        RandomGenerator rand = new RandomGenerator();
        data.add(rand.randomNum());
    }

    public Task2() {
        data = new ArrayList<Double>();
    }

    public ArrayList<Double> getData() {
        return this.data;
    }

    public static void main(String[] args) {
        Task2 run = new Task2();

        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        Thread t4 = new Thread(run);
        Thread t5 = new Thread(run);

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
        
        double sum = 0;
        for(int i = 0; i < (int)(run.getData().size()); i++) {
            sum += run.getData().get(i);
        }
        System.out.printf("The sum is: %.2f ", sum);
    }
}