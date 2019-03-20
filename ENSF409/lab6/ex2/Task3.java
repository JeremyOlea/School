import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Task3 implements Runnable {

    private ArrayList<Double> data;

    synchronized public void run() {
        RandomGenerator rand = new RandomGenerator();
        data.add(rand.randomNum());
    }

    public Task3() {
        data = new ArrayList<Double>();
    }

    public ArrayList<Double> getData() {
        return this.data;
    }

    

    public static void main(String[] args) {
        Task3 run = new Task3();

        ExecutorService pool = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++) {
            pool.execute(run);
        }
        
        try {
            pool.shutdown();
            while (!pool.awaitTermination(24L, TimeUnit.HOURS)) {
            System.out.println("Not yet. Still waiting for termination");
            }
        } catch(InterruptedException e) {
            System.out.println("failed to shutdown");
        }
                
        double sum = 0;
        for(int i = 0; i < run.getData().size(); i++) {
            sum += run.getData().get(i);
        }
        System.out.printf("The sum is: %.2f ", sum);
    }
}