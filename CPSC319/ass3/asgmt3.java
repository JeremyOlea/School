import java.util.*;
import java.io.*;
public class asgmt3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> words = fileRead(scan);
        BST tree = new BST();
        tree = populateTree(words);
        displayStartUp(tree);
        menu(tree, scan);
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
                    Node word = tree.searchWord(find, tree.root);
                    if(word != null) {
                        System.out.println("The word is " + word.word + " and the number of occurrences is " + word.counter);
                    }
                    else {
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

    public static void Traverse(Scanner scan, BST tree) {
        System.out.println("How would you like to print the tree?");
        System.out.println("Enter one of the following:");
        System.out.println("1. In-Order");
        System.out.println("2. pre-Order");
        System.out.println("3. post-Order");
        String input = scan.nextLine();
        switch(input) {
            case "1":
                tree.inOrderTraverse(tree.root);
                break;
            
            case "2":
                tree.preOrderTraverse(tree.root);
                break;
            
            case "3":
                tree.postOrderTraverse(tree.root);
                break;

            default:
                System.out.println("Not a valid input, returning to menu...");
        }

    }

    public static String search(Scanner scan) {
        System.out.println("which word would you like to find?");
        String input = scan.nextLine();
        return input;    
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

    public static void displayStartUp(BST tree) {
        int total = tree.findTotals(tree.root);
        int maxHeight = tree.findHeight(tree.root);
        int unique = tree.findUnique(tree.root);
        ArrayList<Node> list = tree.mostFrequent(tree.root);
        System.out.println("The total number of words in the file is: " + total);
        System.out.println("The number of unique words in the file is: " + unique);
        System.out.println("The max height of the tree is: " + maxHeight);
        System.out.println("The word(s) that occur the mose is/are: ");
        for(Node node : list) {
            System.out.println("\"" + node.word + "\"" + " with " + node.counter + " occurrences");
        }
    }

    public static ArrayList<String> fileRead(Scanner scan) {
        String[] words = null;
        ArrayList<String> filtered = new ArrayList<String>();
        System.out.println("Please enter file name");
        String filename = scan.nextLine();
        try {
            File in = new File(filename);
            Scanner read = new Scanner(in);
            while(read.hasNextLine()) {
                String s = read.nextLine();
                words = s.split("\\s+");
                for(int i=0; i < words.length; i++) {
                    words[i] = words[i].replaceAll("[^\\w]","");
                    filtered.add(words[i].toLowerCase());
                }
            }
            read.close();
            return filtered;
        } catch(FileNotFoundException f) {
            System.out.println("File not found!");
            System.exit(1);
            return filtered;
        }
    }

    public static BST populateTree(ArrayList<String> words) {
        BST newTree = new BST();
        for(int i = 0; i < words.size(); i++) {
            newTree.addNode(words.get(i));
        }
        return newTree;
    }

    




}