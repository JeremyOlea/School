public class RecursiveFibonacci {

    public long Fibonacci(long value) {
        if(value <= 0) return 0;
        else if(value == 1) return 1;
        else
            return (Fibonacci(value-2) + Fibonacci(value-1));
    }

    public static void main(String[] args) {
        long degree = Integer.parseInt(args[0]);
        RecursiveFibonacci myFibonacci = new RecursiveFibonacci();
        long answer = myFibonacci.Fibonacci(degree);
        System.out.printf("The %dth value of a fibonacci sequence is %d", degree, answer);
    }

}