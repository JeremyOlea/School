import java.util.*;
import java.io.*;
public class asgmt3 {
    public static void main(String[] args) {
        String[] words = fileRead();
        BST tree = new BST();
        tree = populateTree(words);
        int total = findTotals(tree.root);
        int maxHeight = findHeight(tree.root);
        int unique = findUnique(tree.root);
        //print(tree.root);
        System.out.println("total " + total);
        System.out.println("max height " + maxHeight);
        System.out.println("unique " + unique);
    }

    public static void print(Node current) {
        if(current.right != null) 
            print(current.right);
        if(current.left != null)
             print(current.left);
        current.toStrin();
    }

    public static String[] fileRead() {
        String[] words = null;
        try {
            File in = new File("file.txt");
            Scanner read = new Scanner(in);
            while(read.hasNextLine()) {
                String s = read.nextLine();
                words = s.split("\\s+");
            }
            for(int i=0; i < words.length; i++) {
                words[i] = words[i].replaceAll("[^\\w]","");
                words[i] = words[i].toLowerCase();
            }
            read.close();
            return words;
        } catch(FileNotFoundException f) {
            System.out.println("File not found!");
            System.exit(1);
            return words;
        }
    }

    public static BST populateTree(String[] words) {
        BST newTree = new BST();
        for(int i = 0; i < words.length; i++) {
            newTree.addNode(words[i]);
        }
        return newTree;
    }

    public static int findTotals(Node current) {
        int count = 1;
        if(current.left != null) {
            count += findTotals(current.left);
        }
        if(current.right != null) {
            count += findTotals(current.right);
        }
        return count;
    }

    public static int findHeight(Node current) {
        if(current == null){
            return 0;
        }
        else {
            int depthLeft = findHeight(current.left);
            int depthRight = findHeight(current.right);

            if(depthLeft > depthRight)
                return (depthLeft+1);
            else
                return (depthRight+1);
        }
    }

    public static int findUnique(Node current) {
        int count = 0;
        if(current.left != null) {
            count += findUnique(current.left);
        }
        if(current.right != null) {
            count += findUnique(current.right);
        }
        if(current.counter == 1) {
            count++;
            return count;
        }
        else return count;
    }
}