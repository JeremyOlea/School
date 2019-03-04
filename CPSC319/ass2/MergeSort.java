public class MergeSort {

    public void mergeSort(String[] list, int lo, int hi) {
        if(lo == hi) {
            return;
        }
        else {
            int mid = (lo + hi)/2;
            mergeSort(list, lo, mid);
            mergeSort(list, mid + 1, hi);
            merge(list, lo, mid, hi);
        }
    }

    public void merge(String[] list, int lo, int mid, int hi) {
        int i, j, k;
        int n1 = mid - lo + 1;
        int n2 = hi - mid;

        String[] left = new String[n1];
        String[] right = new String[n2];

        for (i = 0; i < n1; i++) 
            left[i] = list[lo + i]; 

        for (j = 0; j < n2; j++) 
            right[j] = list[mid + 1 + j];

        i = 0;
        j = 0;
        k = lo;

        while(i < n1 && j < n2) {
            if(left[i].compareTo(right[j]) <= 0) {
                list[k] = left[i];
                i++;
            }
            else {
                list[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            list[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) 
        { 
            list[k] = right[j]; 
            j++; 
            k++; 
        }
    } 

    public void mergeSort(char[] list, int lo, int hi) {
        if(lo == hi) {
            return;
        }
        else {
            int mid = (lo + hi)/2;
            mergeSort(list, lo, mid);
            mergeSort(list, mid + 1, hi);
            merge(list, lo, mid, hi);
        }
    }

    public void merge(char[] list, int lo, int mid, int hi) {
        int i, j, k;
        int n1 = mid - lo + 1;
        int n2 = hi - mid;

        char[] left = new char[n1];
        char[] right = new char[n2];

        for (i = 0; i < n1; i++) 
            left[i] = list[lo + i]; 

        for (j = 0; j < n2; j++) 
            right[j] = list[mid + 1 + j];

        i = 0;
        j = 0;
        k = lo;

        while(i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                list[k] = left[i];
                i++;
            }
            else {
                list[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            list[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) 
        { 
            list[k] = right[j]; 
            j++; 
            k++; 
        }
    }
}


// String[] left = new String[mid - lo + 1];
        
// for (int i = lo; i <= mid; i++) {
//     left[i - lo] = list[i];
// }
// //left[mid - lo + 1] = Integer.MAX_VALUE;
// String[] right = new String[hi - mid];

// for (int i = mid + 1; i <= hi; i++) {
//     right[i - mid - 1] = list[i];
// }
// //right[hi - mid] = Integer.MAX_VALUE;
// int i = 0, j = 0;

// for (int k = lo; k < hi; k++) {
//     if (left[i].compareTo(right[j]) >= 0) {
//         list[k] = left[i];
//         i++;
//     }
//     else {
//         list[k] = right[j];
//         j++;
//     }
// }