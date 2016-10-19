package P3_QuickSort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/17/16.
 */
public class QuickSort {
    public static int compares = 0;

    private QuickSort() {
    }

    public static void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int v = partition(a, lo, hi);
        sort(a, lo, v - 1);
        sort(a, v + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v))
                if (i >= hi)
                    break;
            while (less(v, a[--j]))
                if (j <= lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void shuffle(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int j = StdRandom.uniform(i, a.length);
            exch(a, i, j);
        }
    }

    public static boolean less(Comparable a, Comparable b) {
        compares++;
        return a.compareTo(b) < 0; //can not be <=
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static String toString(Comparable[] a) {
        StringBuilder sb = new StringBuilder();
        for (Comparable i : a) {
            sb.append(i + " ");
        }
        return sb.toString();
    }

    public static int getCompares() {
        return compares;
    }

    public static void main(String[] args) {
        int size = 10;
        Integer[] a = new Integer[size];
        IntStream.range(0, size).parallel().forEach(i -> a[i] = i);
        sort(a);
        for (Comparable i : a) {
            StdOut.print(i + " ");
        }

        StdOut.println();
        int[] sizes = {100, 100, 1000};
        for (int s : sizes) {
            Integer[] arr = new Integer[s];
            IntStream.range(0, s).parallel().forEach(i -> arr[i] = i);
            QuickSort.sort(arr);
            StdOut.println(QuickSort.compares + "/  " + 2 * s * Math.log(s)); //2.3.6 2NlnN average compares time
        }

        StdOut.println();

        for (int s : sizes) {
            Integer[] arr = new Integer[s];
            IntStream.range(0, s).parallel().forEach(i -> { //duplicated element will impact the efficiency
                if (i % 2 == 0)
                    arr[i] = 0;
                else
                    arr[i] = 1;
            });
            QuickSort.sort(arr);
            StdOut.println(QuickSort.compares + "/  " + 2 * s * Math.log(s));
        }

    }
}
