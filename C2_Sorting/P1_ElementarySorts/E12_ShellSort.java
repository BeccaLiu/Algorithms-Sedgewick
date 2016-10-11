package P1_ElementarySorts;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 10/8/16.
 */
public class E12_ShellSort {

    private E12_ShellSort() {
    } //this class should not be initiated

    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1) {
            int count = 0;
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                    count++;
                }
            }
            h = h / 3;
            StdOut.println(count / n);
        }

    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    public static void main(String[] args) {
        for (int j = 1; j < 5; j++) {
            int size = (int) Math.pow(10, j);
            Double[] a = new Double[size];
            for (int i = 0; i < size; i++) {
                a[i] = StdRandom.uniform(0.0, 100.0);
            }
            StdOut.println(size + ":");
            E12_ShellSort.sort(a);
        }
    }
}
