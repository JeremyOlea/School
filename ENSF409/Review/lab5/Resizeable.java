public interface Resizeable {
    static final int LIMIT = 1.0;
    public void shrink(double val) throws SizeFactorException;
    public void enlarge(double val) throws SizeFactorException;
}