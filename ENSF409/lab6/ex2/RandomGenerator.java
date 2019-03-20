public class RandomGenerator {

    public double randomNum() {
        int hi = 100;
        int lo = 1;
        double num = Math.random() * (hi - lo + 1) + lo;
        System.out.printf("The random number generated is: %f\n", num);
        return num;
    }
    
}