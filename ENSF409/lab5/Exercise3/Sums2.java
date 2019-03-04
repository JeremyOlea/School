
import java.io.*;

public class Sums2 {

    public static void sum(BufferedReader in){ 
        // takes a sequence of integers as inputs, and outputs their sum

	int s, nextInt = 0;
	s = 0;

	System.out.println("Please input the sequence of integers to sum, terminated by a 0");
	Boolean valid;
	do{
		try {
			nextInt = Integer.parseInt(in.readLine());
			valid = true;
		} catch(IOException e) {
			System.out.println("Try again");
			valid = false;
		} catch(NumberFormatException f) {
			System.out.println("Try again");
			valid = false;
		}
	}while(valid == false);

	while (nextInt!=0) {
		s = s + nextInt;
		do{
			try {
				nextInt = Integer.parseInt(in.readLine());
				valid = true;
			} catch(IOException e) {
				System.out.println("Try again");
				valid = false;
			} catch(NumberFormatException f) {
				System.out.println("Try again");
				valid = false;
			}
		}while(valid == false);
	    
	}

        System.out.println("The sum is " + s);
    }

    public static void main(String[] arg) {         

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                         //"in" will receive data from the standard input stream
	String c = "";
	boolean valid = true;
	System.out.println("Do you wish to calculate a sum? (y/n)");

	do{
		try {
			c = in.readLine();
			valid = true;
		} catch(IOException e) {
			System.out.println("Try again");
			valid = false;
		} catch(NumberFormatException f) {
			System.out.println("Try again");
			valid = false;
		}
	}while(valid == false);
         //Read next datum in input. A string "y" or "n" is expected

	while (!c.equals("y") && !c.equals("n")) {
		System.out.println("Please answer y or n");
		do{
			try {
				c = in.readLine();
				valid = true;
			} catch(IOException e) {
				System.out.println("Try again");
				valid = false;
			} catch(NumberFormatException f) {
				System.out.println("Try again");
				valid = false;
			}
		}while(valid == false);
	}

	while (c.equals("y")) {
	    sum(in);
		System.out.println("Do you wish to calculate another sum? (y/n)");
		do{
			try {
				c = in.readLine();
				valid = true;
			} catch(IOException e) {
				System.out.println("Try again");
				valid = false;
			} catch(NumberFormatException f) {
				System.out.println("Try again");
				valid = false;
			}
		}while(valid == false);

	    while (!c.equals("y") && !c.equals("n")) {
		System.out.println("Please answer y or n");
		do{
			try {
				c = in.readLine();
				valid = true;
			} catch(IOException e) {
				System.out.println("Try again");
				valid = false;
			} catch(NumberFormatException f) {
				System.out.println("Try again");
				valid = false;
			}
		}while(valid == false);
	    }
	}

	System.out.println("Goodbye");
    }
}
