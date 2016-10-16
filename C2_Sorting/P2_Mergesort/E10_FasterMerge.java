package P2_Mergesort;

import edu.princeton.cs.algs4.StdOut;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/15/16.
 * a little bit confused why it is faster merge, it is just eliminate the condition to check whether halves has been exhausted, but the running time is not changing
 */
public class E10_FasterMerge {
    private static Comparable aux[];

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        aux = new Comparable[a.length]; //copy first halves;
        IntStream.range(lo, mid + 1).parallel().forEach(i -> {
            aux[i] = a[i];
        });
        int finalHi = hi;
        IntStream.range(mid + 1, hi + 1).parallel().forEach(i -> { //copy second halves descreasing order
            aux[i] = a[finalHi - (i - mid - 1)];
        });
        for (int i = lo; i <= finalHi; i++) { //iterate hi-lo time same as normal merge
            if (aux[hi].compareTo(aux[lo]) < 0)
                a[i] = aux[hi--];
            else {
                a[i] = aux[lo++];
            }
        }
    }

    public static void show(Comparable a[]) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        String a[] = {"A", "E", "Q", "S", "U", "Y", "D", "I", "N", "O", "S", "Z"};
        merge(a, 0, 5, 11);

        for (String s : a)
            StdOut.print(s + " ");
    }
}
