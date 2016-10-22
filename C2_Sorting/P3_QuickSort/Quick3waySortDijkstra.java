package P3_QuickSort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/19/16.
 * to figure out the relationship between lo, hi, i, j, lt.
 * 1. use the before status as the invariant analysis
 * 2. use the between status as dealing with the loop inner condition
 * 3. use the after status as closure of the while loop
 */
public class Quick3waySortDijkstra {
    public static void main(String[] args) {
        int s = 20;
        int[] arr = new int[s];
        IntStream.range(0, s).parallel().forEach(i -> {
            arr[i] = StdRandom.uniform(10);
        });
        sort(arr, 0, arr.length - 1);
        IntStream.range(0, s).forEach(i -> {
            StdOut.print(arr[i] + " ");
        });
    }

    public static void sort(int[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int v = a[lo];
        int lt = lo; //lt is start index of equal keys, [lo...lt-1] -> smaller
        int i = lo + 1; //i is unvisited index, i-1 is the right boundary of equal keys. [lt...i-1] -> equal; [i...gt] unvisited
        int gt = hi; //gt+1 is start index of greater keys. [gt+1, hi]->greater

        //different from two while() inside while(true) function, this way of implementation use i<j as closure,
        // so each time we make changes, we need to make sure i<j
        //that's way inside loop we use if ...else if...else... but not if... if... if...
        while (i <= gt) {
            if (a[i] < v) exch(a, i++, lt++); //that's way
            else if (a[i] > v) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }


    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
