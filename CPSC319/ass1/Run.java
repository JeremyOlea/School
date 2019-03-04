public class Run {
    public static void main(String[] args) {
    //     RecursiveFibonacci f = new RecursiveFibonacci();
    //     long a;
    //     for(int i = 0; i < 46; i++) {
    //         long start = System.nanoTime();
    //         a = f.Fibonacci(i);
    //         long end = System.nanoTime();
    //         System.out.printf("Time: %d\n", end - start);
    //         System.out.printf("Value: %d\n", a);
    //         System.out.printf("\n");
    //     }
    // }

    Matrix f = new Matrix();
        long a;
        for(int i = 0; i < 7000; i += 100) {
            long start = System.nanoTime();
            a = f.Fibonacci(i);
            long end = System.nanoTime();
            System.out.println(end - start);
        }
    }
}