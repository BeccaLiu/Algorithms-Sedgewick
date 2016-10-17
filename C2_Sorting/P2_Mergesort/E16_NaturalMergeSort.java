package P2_Mergesort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/16/16.
 * each level to iterate the list once to get lo, mid, hi to merge which take O(N) and to merge take total O(N)
 * so the worst case is 1,2,1,2,1,2...   O(NlogN)
 * the best case is already sorted take O(N)
 */
public class E16_NaturalMergeSort {
    public static void main(String[] args) {
        int size = 50;
        Integer[] a = new Integer[size];
        IntStream.range(0, size).parallel().forEach(i -> a[i] = StdRandom.uniform(100));
        sort(a);
        for (int i : a)
            StdOut.print(i + " ");
    }

    public static void sort(Comparable[] a) {
        int size = a.length;
        while (true) {
            for (int i = 0; i < size - 1; i++) {
                if (isSorted(a))
                    return;
                int lo = i;
                int mid;
                int hi;
                while (i < size - 1 && a[i].compareTo(a[i + 1]) <= 0)
                    i++;
                mid = i++;
                while (i < size - 1 && a[i].compareTo(a[i + 1]) <= 0)
                    i++;
                hi = Math.min(a.length - 1, i);
                merge(a, lo, mid, hi);
            }
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0)
                return false;
        }
        return true;
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        if (hi == mid)
            return;
        Comparable[] aux = new Comparable[mid - lo + 1];
        for (int i = lo; i <= mid; i++)
            aux[i - lo] = a[i];

        int j = 0;
        int k = mid + 1;
        for (int i = lo; i <= hi && j < aux.length; i++) {
            if (k > hi) a[i] = aux[j++];
            else if (aux[j].compareTo(a[k]) < 0)
                a[i] = aux[j++];
            else
                a[i] = a[k++];

        }

    }


}
