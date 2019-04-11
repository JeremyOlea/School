import java.util.*;
public class Task2 implements Runnable{
    
    private ArrayList<Double> data;

    public void run() {
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
        Task2 r1 = new Task2();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        Thread t4 = new Thread(r1);
        Thread t5 = new Thread(r1);

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
        for(int i = 0; i < (int)(r1.getData().size()); i++) {
            sum += r1.getData().get(i);
        }

        System.out.printf("The sum is: %.2f ", sum);
    }
}