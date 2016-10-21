package P3_QuickSort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/20/16.
 */
public class E18_MedianOf3Partition {
    public static void sort(int[] a) {
        StdRandom.shuffle(a);
        //take 1 interation to set right boundes
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
        int size = hi - lo;
        if (size >= 3) {
            int[] index = new int[hi - lo];
            generateMedium(index, a, lo, hi);
            exch(a, lo, index[1]);

            int i = lo + 1;
            int j = hi - 1;
            int v = a[lo];
            while (true) {
                while (a[i] < v)
                    i++;
                while (a[j] > v)
                    j--;

                if (i >= j)
                    break;
                exch(a, i, j);
            }
            exch(a, lo, j);
            return j;
        } else {
            if (a[lo] > a[hi - 1])
                exch(a, lo, hi - 1);
            return lo;
        }

    }

    public static void generateMedium(int[] index, int[] a, int lo, int hi) {
        IntStream.range(0, hi - lo).forEach(i -> index[i] = i + lo);
        StdRandom.shuffle(index);
        //generate unique random number

        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[index[j]] < a[index[j - 1]]) {
                    exch(index, i, j);
                }
            }
        }

    }

    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int size = 150;
        int[] a = new int[size];
        IntStream.range(0, size).parallel().forEach(i -> a[i] = i);
        sort(a);
        for (int i : a) {
            StdOut.print(i + " ");
        }

    }
}
