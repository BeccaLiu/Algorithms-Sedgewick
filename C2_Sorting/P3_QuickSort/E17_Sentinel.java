package P3_QuickSort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/20/16.
 */
public class E17_Sentinel {
    public static void sort(int[] a) {
        //generall shuffle
        StdRandom.shuffle(a);
        int largest = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[largest])
                largest = i;
        }
        exch(a, largest, a.length - 1);
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int p = partition(a, lo, hi);
        sort(a, lo, p);
        sort(a, p + 1, hi);
    }

    public static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi;
        int v = a[lo];
        while (true) {
            while (a[++i] < v && a[i] < a[hi])
                continue;
            while (a[--j] > v)
                continue;
            if (i >= j)
                break;
            exch(a, i, j);
        }

        exch(a, j, lo);
        return j;

    }

    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        int N = 50;

        //generate a random arr;
        int[] arr = new int[N];
        IntStream.range(0, N).forEach(i -> arr[i] = StdRandom.uniform(100));
        StdRandom.shuffle(arr);

        sort(arr);

        IntStream.range(0, N).forEach(i -> StdOut.print(arr[i] + " "));

    }

}
