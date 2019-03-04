import java.io.*;
import java.util.*;

public class asgmt2 {
    public static void main(String args[]) throws IOException {
        if(args.length != 2) {
            System.out.println("Please enter input file name and output file name in command line");
            System.exit(1);
        }
        MergeSort sorter = new MergeSort();
        String[] listA = fileRead(args[0]);
        sorter.mergeSort(listA,0, listA.length-1);
        LinkedList[] listB = anagramList(listA);
        fileOutput(listB, args[1]);
    }

    public static String[] fileRead(String filename) throws IOException{
        String[] words = null;
        try {
            File in = new File(filename);
            Scanner read = new Scanner(in);
            while(read.hasNextLine()) {
                String s = read.nextLine();
                words = addElement(words, s);
            }
            read.close();
            return words;
        } catch(FileNotFoundException f) {
            System.out.println("File not found!");
            System.exit(1);
            return words;
        }
    }

    public static void fileOutput(LinkedList[] list, String filename) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for(int i = 0; i < list.length; i++) {
                writer.write(print(list[i]) + "\n");
            }
            writer.close();
        } catch(FileNotFoundException f) {
            System.out.println("File not found!");
        }
    }
    
    public static Boolean anagramUsed(LinkedList[] arr, String a) {
        if(arr == null) {
            return false;
        }
        else {
            for(int i = 0; i < arr.length; i++) {
                if(checkAnagram(arr[i].get(0),a)) {
                    return true;
                }
            }
            return false;
        }
      
    }

    public static LinkedList[] anagramList(String[] words) {
        LinkedList[] arr = null;
        for(int i = 0; i < words.length; i++) {
            if(!anagramUsed(arr, words[i])) {
                LinkedList newList = new LinkedList();
                newList.push_back(words[i]);
                for(int j = i+1; j < words.length; j++) {
                    if(checkAnagram(words[j], newList.get(0))) {
                        newList.push_back(words[j]);
                    }
                }
                arr = addElement(arr, newList);
            }
        }
        return arr;
    }

    public static Boolean checkAnagram(String a, String b) {
        MergeSort sorter = new MergeSort();
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        if(aChars.length != bChars.length)
            return false;
        else {
            sorter.mergeSort(aChars, 0, aChars.length-1);
            sorter.mergeSort(bChars, 0, bChars.length-1);
            for(int i = 0; i < aChars.length; i++) {
                if(aChars[i] != bChars[i])
                    return false;
            }
            return true;
        }
    }


    public static String[] addElement(String[] arr, String list) {
        if(arr == null) {
            String[] newArray = new String[1];
            newArray[0] = list;
            return newArray;
        }
        else {
            String[] newArray = new String[arr.length+1];
            int i;
            for(i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
            }
            newArray[i] = list;
            return newArray;
        }
    }

    public static LinkedList[] addElement(LinkedList[] arr, LinkedList list) {
        if(arr == null) {
            LinkedList[] newArray = new LinkedList[1];
            newArray[0] = list;
            return newArray;
        }
        else {
            LinkedList[] newArray = new LinkedList[arr.length+1];
            int i;
            for(i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
            }
            newArray[i] = list;
            return newArray;
        }
    }

    public static String print(LinkedList list) {
        String s = new String();
        for(int i = 0; i < list.getSize(); i++) {
            s += list.get(i) + " ";
        }
        return s;
    }
}