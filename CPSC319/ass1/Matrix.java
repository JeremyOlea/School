
public class Matrix {

    static int FM[][] = new int[2][2];

    public static int[][] Multiply(int matrix1[][], int matrix2[][])
    {
        int resMatrix[][] = new int[2][2];
        int i, j, k, res;
        for(i = 0; i < 2; i++) {
            for(j = 0; j < 2; j++) {
                res = 0;
                resMatrix[i][j] = 0;

                for(k = 0; k < 2; k++) {
                    res = matrix1[i][k] * matrix2[k][j];
                    resMatrix[i][j] = resMatrix[i][j] + res;
                }
            }
        }
        return resMatrix;
    }

    public static void MatrixPower(int n) {
        if(n > 1) {
            MatrixPower(n/2);
            FM = Multiply(FM, FM);

            if(n % 2 != 0) {
                int FM2[][] = new int[2][2];
                FM2[0][0] = 1;
                FM2[0][1] = 1;
                FM2[1][0] = 1;
                FM2[1][1] = 0;
                FM = Multiply(FM, FM2);
            }
        }
    }

    public static int Fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        FM[0][0] = 1;
        FM[0][1] = 1;
        FM[1][0] = 1;
        FM[1][1] = 0;
        MatrixPower(n-1);
        return FM[0][0];
    }

    public static void main(String args[]) {
        int val = Integer.parseInt(args[0]);
        int answer;
        answer = Fibonacci(val);
        System.out.print(answer);
    }
}

        // int matrix1[][] = {{1,1},{2,2}};
        // int matrix2[][] = {{1,1},{2,3}};

        // int i,j;
        // int resMatrix[][] = {};
        // Multiply(matrix1, matrix2, resMatrix);

        // for(i = 0; i < 2; i++) {
        //     for(j = 0; j < 2; j++) 
        //         System.out.printf("%d", resMatrix[i][j]);
        //     System.out.printf("\n");
        // }