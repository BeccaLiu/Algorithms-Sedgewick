package P2_Mergesort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/16/16.
 */
public class E22_3WayMergeSort {
    public static void main(String[] args) {
        int size = 50;
        int[] a = new int[size];
        IntStream.range(0, size).parallel().forEach(i -> a[i] = i);
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);

        for (int i = 0; i < size; i++) {
            StdOut.print(a[a[i]] + " ");
        }
    }

    public static void sort(int[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid1;
        int mid2;
        if (hi - lo < 2) {
            mid1 = lo;
            mid2 = Math.min(lo + 1, hi);
        } else {
            int interval = (hi - lo + 1) / 3;
            mid1 = lo + interval - 1;
            mid2 = mid1 + interval;
        }
        sort(a, lo, mid1);
        sort(a, mid1 + 1, mid2);
        sort(a, mid2 + 1, hi);

        merge(a, lo, mid1, mid2, hi);
    }

    public static void merge(int[] a, int lo, int mid1, int mid2, int hi) {
        int[] aux1 = new int[mid1 - lo + 1];
        int[] aux2 = new int[mid2 - mid1];
        for (int i = lo; i <= mid1; i++) {
            aux1[i - lo] = a[i];
        }
        for (int i = mid1 + 1; i <= mid2; i++) {
            aux2[i - mid1 - 1] = a[i];
        }

        int m1 = 0;
        int m2 = 0;
        int m3 = mid2 + 1;
        for (int i = lo; i <= hi; i++) {
            //one of three is empty;
            if (m1 >= aux1.length && m2 >= aux2.length)
                break;
            else if (m2 >= aux2.length && m3 > hi)
                a[i] = aux1[m1++];
            else if (m1 >= aux1.length && m3 > hi)
                a[i] = aux2[m2++];
                //one of two is empty
            else if (m1 >= aux1.length) {
                a[i] = aux2[m2] > a[m3] ? a[m3++] : aux2[m2++];
            } else if (m2 >= aux2.length) {
                a[i] = aux1[m1] > a[m3] ? a[m3++] : aux1[m1++];
            } else if (m3 > hi) {
                a[i] = aux1[m1] > aux2[m2] ? aux2[m2++] : aux1[m1++];
            } else if (m1 < aux1.length && m2 < aux2.length && m3 <= hi && aux1[m1] < aux2[m2] && aux1[m1] < a[m3])
                a[i] = aux1[m1++];
            else if (m1 < aux1.length && m2 < aux2.length && m3 <= hi && aux2[m2] < a[m3] && aux2[m2] < aux1[m1])
                a[i] = aux2[m2++];
            else if (m1 < aux1.length && m2 < aux2.length && m3 <= hi && a[m3] < aux1[m1] && a[m3] < aux2[m2])
                a[i] = a[m3++];

        }
    }
}
