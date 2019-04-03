import java.io.*;
import java.util.*;

public class asgmt4 {
    private static int row;
    private static int col;
    private static int size;

    public static void main(String[] args) {
        ArrayList<Neighbourhood> neighbourhoodList = readFile();
        int[][] matrix = createMatrix(neighbourhoodList);
    }

    public static int calculateWeight(Neighbourhood one, Neighbourhood two) {
        int[][] gridOne = one.getGrid();
        int[][] gridTwo = two.getGrid();
        int sum = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                sum += (gridOne[i][j] - gridTwo[i][j]);
            }
        }
        return sum;
    }

    public static int[][] createMatrix(ArrayList<Neighbourhood> n) {
        int[][] tempMatrix = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                int weight = calculateWeight(n.get(i), n.get(j));
                tempMatrix[i][j] = weight;
            }
        }
        return tempMatrix;
    }

    public static ArrayList<Neighbourhood> readFile() {
        ArrayList<Neighbourhood> neighbourhoodList = new ArrayList<Neighbourhood>();
        row = 0;
        col = 0;
        size = 0;
        String input = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter file name");
        String filename = scan.nextLine();
        try {
            File in = new File(filename);
            Scanner read = new Scanner(in);
            if(read.hasNextLine()) {
                input = read.nextLine();
                String[] dimensions = input.split("\\s+");
                row = Integer.parseInt(dimensions[0]);
                col = Integer.parseInt(dimensions[1]);
            }
            if(read.hasNextLine()) {
                input = read.nextLine();
                size = Integer.parseInt(input);
            }

            int[][] block = new int[row][col];
            for(int k = 0; k < size; k++) {
                for(int i = 0; i < row; i++) {
                    for(int j = 0; j < col; j++) {
                        if(read.hasNextLine()) {
                            read.nextInt(); //not to read the header int
                            int integerInput = read.nextInt();
                            block[i][j] = integerInput;
                        }
                    }
                }
                Neighbourhood neighbourhood = new Neighbourhood(row, col, block);
                neighbourhoodList.add(neighbourhood);
            }
            read.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found!");
        }
        scan.close();
        return neighbourhoodList;
    }
}