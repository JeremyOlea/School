import java.util.ArrayList;
import java.util.Scanner;

class Marathon {
    public int findFastestRunner(ArrayList <Integer> times) {
        int index = 0;
        for(int i = 0; i < times.size(); i++) {
            if(times.get(index) > times.get(i))
                index = i;
        }
        return index;
    }

    public static void main(String[] args) {
        //Define two array lists here to store the names and the running times
        ArrayList <String> runners = new ArrayList <String>();
        ArrayList <Integer> times = new ArrayList <Integer>();
        
        String sin;
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Please enter the name of the participant");
            sin = scan.nextLine();
            if(sin.toUpperCase().equals("QUIT"))
                break;

            runners.add(sin);

            System.out.println("Please enter the running time of the participant");
            sin = scan.nextLine();

            //Add the running time to you array list
            times.add(Integer.parseInt(sin));

        }
        Marathon myMarathon = new Marathon();
        int result;
        //Call the function findFastestRunner and pass the running times aray list in it
        result = myMarathon.findFastestRunner(times);
        //Print name of the fastest runner to the console
        System.out.printf("\nThe fastest runner is %s", runners.get(result));
    }
}