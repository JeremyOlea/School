
import java.io.*;

public class Sums {

	public static int readNumber(BufferedReader in) {
		int num = -1;
		boolean valid = false;
		do{
			try{
				num = Integer.parseInt(in.readLine());
				valid = true;
			} catch(NumberFormatException f) {
				System.out.println("Invalid input. Please reenter");
			} catch(IOException f) {
				System.out.println("Invalid input. Please reenter");
			}
		} while(!valid);
		return num;
	}

	public static String readLine(BufferedReader in) {
		String s = null;
		boolean valid = false;
		do{
			try{
				s = in.readLine();
				valid = true;
			} catch(NumberFormatException f) {
				System.out.println("Invalid input. Please reenter");
			} catch(IOException f) {
				System.out.println("Invalid input. Please reenter");
			}
		} while(!valid);
		return s;
	}

    public static void sum(BufferedReader in){ 
        // takes a sequence of integers as inputs, and outputs their sum

		int s, nextInt = 0;
		s = 0;

		System.out.println("Please input the sequence of integers to sum, terminated by a 0");
		nextInt = readNumber(in);

		while (nextInt!=0) {
			s = s + nextInt;
			nextInt = readNumber(in);	    
		}

        System.out.println("The sum is " + s);
    }

    public static void main(String[] arg) {         

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                         //"in" will receive data from the standard input stream
		String c;
		System.out.println("Do you wish to calculate a sum? (y/n)");
		c = readLine(in);
         //Read next datum in input. A string "y" or "n" is expected

		while (!c.equals("y") && !c.equals("n")) {
			System.out.println("Please answer y or n");
			c = readLine(in);
		}

		while (c.equals("y")) {
	    	sum(in);
			System.out.println("Do you wish to calculate another sum? (y/n)");
			c = readLine(in);

	    	while (!c.equals("y") && !c.equals("n")) {
				System.out.println("Please answer y or n");
				c = readLine(in);
	    	}
		}

		System.out.println("Goodbye");
    }
}
