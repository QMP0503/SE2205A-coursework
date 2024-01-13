package LE6Q1;

import java.util.*;

public class QuangTestingSortingMethods {
    public static void main(String[] args){
        myHeader(6);
        int sz = 10;
        Integer[] testArray = new Integer[sz];
        Integer[] backupArray = new Integer[testArray.length];
        for(int i = 0; i<testArray.length; i++){
            testArray[i] = (int)(13+81*Math.random()); //java always round up
        }
        System.arraycopy(testArray,0,backupArray,0,testArray.length);
        List<Integer> listArray= Arrays.asList(testArray);
        List<Integer> listBackup= Arrays.asList(backupArray);
        long startCollection= System.nanoTime();
        Collections.sort(listArray);
        long endCollection = System.nanoTime();
        System.out.println("The unsorted list: " + listBackup);
        System.out.printf("Collections' Sorting Time: %.4f milliseconds\n", (endCollection-startCollection)*1e-6);
        System.out.println("The sorted list using Collections' sort method: " + listArray);
        System.out.println();
        System.arraycopy(backupArray,0,testArray,0,testArray.length);
        printInfo("Selection-Sort",listBackup,listArray,selectionSort(testArray)*1e-6);
        System.arraycopy(backupArray,0,testArray,0,testArray.length);
        printInfo("Bubble-Sort",listBackup,listArray,bubbleSort(testArray)*1e-6);
        System.arraycopy(backupArray,0,testArray,0,testArray.length);
        printInfo("Insertion-Sort",listBackup,listArray,insertionSort(testArray)*1e-6);
        System.arraycopy(backupArray,0,testArray,0,testArray.length);
        printInfo("Merge-Sort",listBackup,listArray,mergeSort(testArray)*1e-6);
        System.arraycopy(backupArray,0,testArray,0,testArray.length);
        printInfo("Quick-Sort",listBackup,listArray,quickSort(testArray,0,testArray.length-1)*1e-6);
        System.arraycopy(backupArray,0,testArray,0,testArray.length);
        printInfo("Bucket-Sort",listBackup,listArray,bucketSort(testArray,0,testArray.length-1,2)*1e-6);//max digit is set to two because max number is 93
        myFooter(6);
    }
    public static void printInfo(String methodName, List<Integer> unsorted, List<Integer> sorted, double time) {
        System.out.println("The unsorted list: " + unsorted.toString());
        System.out.printf("My %s Time: %.4f milliseconds\n", methodName, time);
        System.out.printf("The sorted list using %s method: " + sorted+"\n",methodName.toLowerCase());
        System.out.println();
    }
    public static <T extends Comparable <? super T>>long selectionSort (T [] a){
        long startTime = System.nanoTime();
        for(int i=0; i<a.length;i++){
            int k = i; //storing index of value
            for(int j = i+1;j<a.length;j++){ //going through the rest of the array after initial value
                if (a[j].compareTo(a[k])==-1){ //checking if there's a smaller value in array
                    k = j; //store index of smaller value
                }
            }
            T temp = a[i];
            a[i] = a[k];
            a[k] = temp;//assigning correct value to sort list before moving to next value in outer index
        }
        long endTime = System.nanoTime();
        return endTime-startTime;
    }
    public static < T extends Comparable <? super T >> long bubbleSort(T[] a){
        long startTime = System.nanoTime();
        for (int i = 1; i < a.length ; i++) {//outer index to go through individual elements
            for (int j = 0; j < a.length - i; j++) {//inner index to compare element before outer index
                if (a[j].compareTo(a[j + 1])>0) {//if smaller let switch position
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }//this process repeats until the data is fully sorted
        }
        long endTime = System.nanoTime();
        return endTime-startTime;
    }
    public static < T extends Comparable <? super T >> long insertionSort(T[] a){
        long startTime = System.nanoTime();
        for(int i = 1; i<a.length; i++){
            T key = a[i];
            int j = i-1; //setting value for inner index to compare value to rest of array
            while(j>=0 && a[j].compareTo(key)>0){
                a[j+1]=a[j];
                j--;
            }//repeat comparison until the value is at the beginning of the list or in correct location
            a[j+1]=key;
        }
        long endTime = System.nanoTime();
        return endTime-startTime;
    }
    public static <T extends Comparable<? super T>> long mergeSort(T[] S){
        long startTime = System.nanoTime();
        int n = S.length;
        if (n < 2){
            long endTime = System.nanoTime();
            return endTime-startTime; // array is trivially sorted
        }
        // divide
        int mid = n/2;
        T[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of first half
        T[] S2 = Arrays.copyOfRange(S, mid, n); // copy of second half
        // conquer (with recursion)
        mergeSort(S1); // sort copy of first half
        mergeSort(S2); // sort copy of second half

        // merge sorted halves back into original
        int i = 0, j = 0, k = 0;
        while (i < S1.length && j < S2.length) {
            if (S1[i].compareTo(S2[j]) <= 0) {
                S[k++] = S1[i++];
            } else {
                S[k++] = S2[j++];
            }
        }

        // Copy the remaining elements of S1 and S2, if any
        while (i < S1.length) {
            S[k++] = S1[i++];
        }

        while (j < S2.length) {
            S[k++] = S2[j++];
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b){
        long startTime = System.nanoTime();
        if(a>=b){
            long endTime = System.nanoTime();
            return endTime-startTime;
        }
        T pivot = s[b]; //pivot moved to the last element
        int l = a;//left most counter will scan rightwards from first element
        int r = b-1;//right most counter which will count from the 2nd last element
        while(l<=r){
            while(l<=r && s[l].compareTo(pivot)<=0){
                l++;
            }
            while(l<=r && s[r].compareTo(pivot)>=0){
                r--;
            }
            if (l < r){
                T temp = s[r];
                s[r] = s[l];
                s[l] = temp;
                l++;
                r--;
            }
        }
        T temp = s[b];
        s[b] = s[l];
        s[l] = temp;
        quickSort(s,a,l-1);
        quickSort(s,l+1,b);
        long endTime = System.nanoTime();
        return endTime-startTime;
    }
    public static long bucketSort(Integer[] a, int first, int last, int maxDigits){
        long startTime=System.nanoTime();
        Vector<Integer>[] bucket = new Vector[10];
        //instantiate each bucket;
        for (int i = 0; i < 10; i++)
            bucket[i] = new Vector<>();
        for (int i = 0; i < maxDigits; i++) {
            //clear the Vector buckets
            for (int j = 0; j < 10; j++) { //remove all element from the bucket
                bucket[j].removeAllElements();
            }
            for (int index = first; index <= last; index++) {//assigning elements to the buckets
                int number = a[index];
                int digit = 0;
                for (int k = 0; k <= i; k++) {
                    digit = number % 10;
                    number = number / 10;
                }
                bucket[digit].add(a[index]);
            }
            int index = 0;
            for (int m = 0; m < 10; m++) { //adding bucket sort to original array
                for (int n = 0; n < bucket[m].size(); n++) {
                    a[index++] = bucket[m].get(n);
                }
            }
        }
        long endTime = System.nanoTime();
        return endTime-startTime;
    }
    public static void myHeader(int labNum) {
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise %d, Q1\n", labNum);
        System.out.println("Prepared By: Quang Pham");
        System.out.println("Student Number: 251271238");
        System.out.println("Goal of this Exercise: Testing Sorting method execution time.");
        System.out.println("=======================================================");
    }
    public static void myFooter(int labNum) {
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Exercise %d, Q1 is successful!\n", labNum);
        System.out.println("Signing off - Quang");
        System.out.println("=======================================================");
    }
}
