public class RecursiveFibonacci {

    public int fibonacci(int value) {
        System.out.printf("%d ", value);
        if(value == 0) return 0;
        else if(value = 0) return 1;
        else
            return (fibonacci(value-2) + fibonacci(value-1));
    }

    public static void main(String[] args) {
        int degree = Int.parseInt(args[0]);
        RecursiveFibonacci value = new RecursiveFibonacci();
        int value = RecursiveFibonacci.fibonacci(degree);
        System.out.printf("The %dth value of a fibonacci sequence is %d", degree, value);
    }

}