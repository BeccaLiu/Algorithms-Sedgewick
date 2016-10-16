package P2_Mergesort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/15/16.
 */
public class E11_IpvMergeSort {
    private static final int CUTOFF = 7;

    public static void sort(Comparable[] src, Comparable[] des, int lo, int hi) {
        if (lo >= hi)
            return;
        if ((hi - lo) <= CUTOFF) { //use insertion sort for small subarrays
            insertionSort(des, lo, hi); //no matter what, insertion sort only apply on des. Thinking in recursive, what is matter is current stage.
            return;
        } else {
            int mid = lo + (hi - lo) / 2;
            sort(des, src, lo, mid);
            sort(des, src, mid + 1, hi); //why it is work? if using sort(src,des,...) then the src and des is alway not changing
            if (src[mid].compareTo(src[mid + 1]) > 0) //test whether array is already sorted
                merge(des, src, lo, hi); //always merge from src to des
        }
    }

    public static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && a[j].compareTo(a[j - 1]) < 0; j--) {
                Comparable temp = a[j - 1];
                a[j - 1] = a[j];
                a[j] = temp;
            }
        }
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) { //k <= hi not k<hi
            if (i > mid)
                a[k] = aux[j++]; //when one subarray already has nothing to be compared, just copy the other subarray as it is already sorted
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) < 0) {
                a[k] = aux[i++];
            } else
                a[k] = aux[j++];
        }

    }

    public static void main(String[] args) {
        int size = 50;
        Integer[] arr = new Integer[size];
        IntStream.range(0, size).parallel().forEach(i -> {
            arr[i] = StdRandom.uniform(50);
        });

        Comparable[] aux = new Comparable[arr.length];
        IntStream.range(0, arr.length).parallel().forEach(i -> { //no need to copy all of the array, just copy from lo to hi(hi included)
            aux[i] = arr[i];
        });
        sort(aux, arr, 0, arr.length - 1);

        for (int i : arr)
            StdOut.print(i + " ");
    }
}
