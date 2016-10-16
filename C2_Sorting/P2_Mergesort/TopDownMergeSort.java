package P2_Mergesort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/14/16.
 */
public class TopDownMergeSort {
    //private static Comparable[] aux;
    private TopDownMergeSort() {
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) < 0) {
                a[k] = aux[i++];
            } else
                a[k] = aux[j++];
        }
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        Comparable[] aux = new Comparable[a.length]; //remove aux as a static array
        IntStream.range(lo, hi + 1).parallel().forEach(i -> {
            aux[i] = a[i];
        });
        if (a[mid].compareTo(a[mid + 1]) > 0)//2.2.8 skip merge when a[mid]<=a[mid+1], as a is sorted.
            merge(a, aux, lo, mid, hi);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[50];
        IntStream.range(0, 50).parallel().forEach(i -> {
            arr[i] = StdRandom.uniform(100);
        });

        TopDownMergeSort.sort(arr, 0, arr.length - 1);
        IntStream.range(0, arr.length).forEach(i -> {
            StdOut.print(arr[i] + " ");
        });

    }
}
