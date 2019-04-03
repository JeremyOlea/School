public class Matrix {
    private int[][] matrix;

    // public Matrix() {
    //     matrix = new int[][];
    // }

    public Matrix(int size) {
        matrix = new int[size][size];
    }

    public void setWeight(int r, int c, int val) {
        matrix[r][c] = val;
    }
}