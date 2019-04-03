public class Neighbourhood {
    private int row;
    private int col;
    private int[][] grid;

    public Neighbourhood(int r, int c, int[][] a) {
        row = r;
        col = c;
        grid = new int[r][c];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                grid[i][j] = a[i][j];
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }

}