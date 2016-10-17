package P2_Mergesort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/16/16.
 */
public class E20_indirectSort {

    public static void main(String[] args) {
        int size = 50;
        int[] a = new int[size];
        IntStream.range(0, size).parallel().forEach(i -> a[i] = i);
        StdRandom.shuffle(a);

        int[] perm = new int[size];
        IntStream.range(0, size).parallel().forEach(i -> perm[i] = i);
        sort(a, perm, 0, a.length - 1);

        for (int i = 0; i < size; i++) {
            StdOut.print(a[perm[i]] + " ");
        }

    }

    public static void sort(int[] a, int[] perm, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, perm, lo, mid);
        sort(a, perm, mid + 1, hi);
        merge(a, perm, lo, mid, hi);
    }

    public static void merge(int[] a, int[] perm, int lo, int mid, int hi) {
        int[] aux = new int[mid - lo + 1];
        for (int i = lo; i <= mid; i++) {
            aux[i - lo] = perm[i];
        }
        int m = 0;
        int n = mid + 1;

        for (int i = lo; i <= hi && m < aux.length; i++) {
            if (n > hi)
                perm[i] = aux[m++];
            else if ((a[aux[m]] < a[perm[n]]))
                perm[i] = aux[m++];
            else
                perm[i] = perm[n++];
        }
    }
}
