//import java.io.*;
import java.util.*;

public class QuickSort {

    public QuickSort() {

    }

    public void quickSort(String[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(String[] arr, int lo, int hi) {
        if(lo < hi+1) {
            int p = partition(arr, lo, hi);
            quickSort(arr, lo, p-1);
            quickSort(arr, p+1, hi);
        }
    }

    public static int partition(String[] arr, int lo, int hi) {
        swap(arr, lo, pivot(lo, hi));
        int border = lo + 1;
        for(int i = border; i <= hi; i++) {
            if(arr[i].compareTo(arr[lo]) < 0) {
                swap(arr, i, border++);
            }
        }
        swap(arr, lo, border-1);
        return border-1;
    }

    public static void swap(String[] arr, int first, int second) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void printArray(String[] arr) {
        for(String word : arr) {
            System.out.println(word);
        }
    }


    public void quickSort(char[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(char[] arr, int lo, int hi) {
        if(lo < hi+1) {
            int p = partition(arr, lo, hi);
            quickSort(arr, lo, p-1);
            quickSort(arr, p+1, hi);
        }
    }

    public static int partition(char[] arr, int lo, int hi) {
        swap(arr, lo, pivot(lo, hi));
        int border = lo + 1;
        for(int i = border; i <= hi; i++) {
            if(arr[i] < arr[lo]) {
                swap(arr, i, border++);
            }
        }
        swap(arr, lo, border-1);
        return border-1;
    }

    public static void swap(char[] arr, int first, int second) {
        char temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int pivot(int lo, int hi) {
        Random ran = new Random();
        return ran.nextInt((hi-lo) + 1) + lo;
    }
}


    // public static LinkedList[] anagramList(String[] words) {
    //     LinkedList[] arr = null;
    //     String[] temp = new String[words.length];
    //     for(int n = 0; n < words.length; n++) {
    //         temp[n] = words[n];
    //     }
    //     for(int i = 0; i < words.length; i++) {
    //         LinkedList newList = new LinkedList();
    //         if(temp[i].compareTo("\0") != 0) {
    //             newList.push_back(temp[i]);
    //             for(int j = 0; j < words.length - i - 1; j++) {
    //                 if(checkAnagram(temp[i], temp[i+j+1])) {
    //                     newList.push_back(temp[i+j+1]);
    //                     temp[i+j+1] = "\0";
    //                 }
    //             }
    //             arr = addElement(arr, newList);
    //         }
    //     }
    //     return arr;
    // }
    
    // public static String print(LinkedList list) {
    //     String s = new String();
    //     for(int i = 0; i < list.getSize(); i++) {
    //         s += list.get(i) + " ";
    //     }
    //     //s += "\n";
    //     return s;
    // }

        // public static LinkedList[] anagramList(String[] words) {
    //     LinkedList[] arr = null;
    //     LinkedList copy = new LinkedList();
    //     for(int n = 0; n < words.length; n++) {
    //         copy.push_back(words[n]);
    //     }
    //     while(copy.getHead () != null) {
    //         LinkedList newList = new LinkedList();
    //         newList.push_back(copy.get(0));
    //         copy.remove(0);
    //         for(int j = 0; j < copy.getSize(); j++) {
    //             if(checkAnagram(copy.get(j), newList.get(0))) {
    //                 newList.push_back(copy.get(j));
    //                 copy.remove(j);
    //                 j--;
    //             }
    //         }
    //         arr = addElement(arr, newList);
    //     }
    //     return arr;
    // }