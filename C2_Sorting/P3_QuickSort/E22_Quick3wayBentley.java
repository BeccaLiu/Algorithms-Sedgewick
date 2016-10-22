package P3_QuickSort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/21/16.
 * this way of implements quick three way sort is same as dijkstra quick three way sort which sort equal keys in the center-
 */
public class E22_Quick3wayBentley {
    public static void sort(int[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int v = a[lo];
        int p = lo + 1; //right boundary of left equal keys, start index of less
        int i = lo + 1; //right boundary of less keys. start index of unvisited keys
        int j = hi; //end of unvisited, left boundary of greater keys
        int q = hi + 1;//start index of right equal keys


        //stuck at how to deal with the relationship between i, j, p, q for a long time.
        while (i <= j) {
            while (i <= j && a[i] < v)
                i++;
            while (i <= j && a[i] == v)
                exch(a, p++, i++);
            if (i <= j && a[i] == v)
                exch(a, i, j--);
            while (i <= j && a[j] > v)
                j--;
            while (i <= j && a[j] < v)
                exch(a, j, i++);
            if (i <= j && a[j] == v)
                exch(a, j--, --q);
        }

        while (p > lo) {
            exch(a, --p, j--);
        }

        while (q <= hi) {
            exch(a, q++, i++);
        }

        sort(a, lo, j);
        sort(a, i, hi);
    }

    public static void main(String[] args) {
        int s = 130;
        int[] arr = new int[s];

        IntStream.range(0, s).parallel().forEach(i -> {
            arr[i] = StdRandom.uniform(10);
        });
        IntStream.range(0, s).forEach(i -> {
            StdOut.print(arr[i] + " ");
        });
        StdOut.println();
        sort(arr, 0, arr.length - 1);
        IntStream.range(0, s).forEach(i -> {
            StdOut.print(arr[i] + " ");
        });
    }

    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
