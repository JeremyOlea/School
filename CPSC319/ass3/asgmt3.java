import java.util.*;
import java.io.*;
public class asgmt3 {

    public static String filename;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> words = fileRead(scan);
        BST tree = new BST();
        tree = populateTree(words);
        displayStartUp(tree);
        menu(tree, scan);
    }

    public static ArrayList<String> fileRead(Scanner scan) {
        String[] words = null;
        ArrayList<String> filtered = new ArrayList<String>();
        System.out.println("Please enter file name");
        filename = scan.nextLine();
        String file = filename + ".txt";
        try {
            File in = new File(file);
            Scanner read = new Scanner(in);
            while(read.hasNextLine()) {
                String s = read.nextLine(); //grabs line
                if(!s.replaceAll("\\s", "").equals("")) { //error checks for empty lines
                    words = s.replaceAll("-"," ").split("\\s+"); //filters out hyphens and splits into array at one or more spaces
                        for(int i=0; i < words.length; i++) {
                        words[i] = words[i].replaceAll("\\p{P}",""); //removes punctuation
                        filtered.add(words[i].toLowerCase()); //adds each word in the line to an ArrayList called 'filtered'
                    }
                }
            }
            read.close();
        } catch(FileNotFoundException f) {
            System.out.println("File not found!");
            System.exit(1);  
        }

        return filtered;
    }

    public static BST populateTree(ArrayList<String> words) {
        BST newTree = new BST();
        for(int i = 0; i < words.size(); i++) {
            newTree.addNode(words.get(i));
        }
        return newTree;
    }

    public static void displayStartUp(BST tree) {
        int total = tree.findTotals(tree.root);
        int maxHeight = tree.findHeight(tree.root);
        int unique = tree.findUnique(tree.root);
        System.out.println("Total number of words in " + filename + " = "  + total);
        System.out.println("Number of unique words in " + filename + " = " + unique);
        System.out.println("The word(s) which occur(s) most often and the number of times that it/they occur(s) = ");
        tree.printFrequent(tree.root);
        System.out.println("The max height of the tree = " + maxHeight);

    }

    public static void menu(BST tree, Scanner scan) {
        while(true) {
            String in = "";
            try {
                in = menuInput(scan);
            } catch(Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }

            switch(in) {
                case "1":
                    String find = search(scan);
                    boolean found = tree.searchWord(find,tree.root);
                    if(!found) {
                        System.out.println("Word does not exist!");
                    }
                    break;
                
                case "2":
                    Traverse(scan, tree);
                    break;

                case "3":
                    scan.close();
                    System.out.println("Goodbye!");
                    System.exit(1);
                    break;

                default:
                    System.out.println("Invalid input, please try again");
            }
        }
    }

    public static String menuInput(Scanner scan) throws IOException {
        System.out.println();
        System.out.println("Please select one of the following");
        System.out.println("1. Request information about a word");
        System.out.println("2. Display the entire tree");
        System.out.println("3. QUIT");
        String input = scan.nextLine();
        return input;
    }

    public static String search(Scanner scan) {
        System.out.println("which word would you like to find?");
        String input = scan.nextLine();
        return input;    
    }

    public static void Traverse(Scanner scan, BST tree) {
        System.out.println("How would you like to print the tree?");
        System.out.println("Enter one of the following:");
        System.out.println("1. In-Order");
        System.out.println("2. pre-Order");
        System.out.println("3. post-Order");
        String input = scan.nextLine();
        switch(input) {
            case "1":
                System.out.println("IN-ORDER: ");
                tree.inOrderTraverse(tree.root);
                break;
            
            case "2":
                System.out.println("PRE-ORDER: ");
                tree.preOrderTraverse(tree.root);
                break;
            
            case "3":
                System.out.println("POST-ORDER: ");
                tree.postOrderTraverse(tree.root);
                break;

            default:
                System.out.println("Not a valid input, returning to menu...");
        }

    }
}