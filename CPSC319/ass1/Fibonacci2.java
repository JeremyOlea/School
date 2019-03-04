public class Fibonacci2 {
    public int Fibonacci(int value) {
        int x = 1;
        int y = 1;
        int temp;
        if(value == 0) return 0;
        else if(value == 1) return 1;
        else {
            for(int i = 2; i < value; i++) {
                temp = x;
                x = y + temp;
                y = temp;
            }
            return x;
        }
    }

    public static void main(String[] args) {
        int degree = Integer.parseInt(args[0]);
        Fibonacci2 myFibonacci = new Fibonacci2();
        int answer = myFibonacci.Fibonacci(degree);
        System.out.printf("The %dth value of a fibonacci sequence is %d", degree, answer);
    }

}