package P2_Mergesort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/14/16.
 */
public class BottomUpMergeSort {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz *= 2) {
            for (int lo = 0; lo < N - sz; lo += sz * 2) {
                merge(a, lo, lo + sz - 1, Math.min(N - 1, lo + 2 * sz - 1));
            }
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        Comparable[] aux = new Comparable[a.length];
        IntStream.range(lo, hi + 1).parallel().forEach(i -> { //no need to copy all of the array, just copy from lo to hi(hi included)
            aux[i] = a[i];
        });
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
        BottomUpMergeSort.sort(arr);
        IntStream.range(0, arr.length).forEach(i -> {
            StdOut.println(i + ":" + arr[i]);
        });

    }
}
