public class SizeFactorException extends Exception{
    public SizeFactorException(double limit) {
        super("The input must be greater than or equal to " + limit);
    }
}