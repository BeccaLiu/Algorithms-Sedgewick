package P2_Mergesort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by rliu on 10/16/16.
 * still a little bit confused by what is the aim for this problem.
 */
public class E12_SublinearMerge {

    public static void main(String[] args) {
        int N = 50;
        int M = 10;
        Integer[] arr = new Integer[N];
        IntStream.range(0, N).parallel().forEach(i -> {
            arr[i] = i;
        });
        StdRandom.shuffle(arr);
        for (int i = 0; i < N / M; i++)
            Arrays.sort(arr, i * M, (i + 1) * M);

        print(arr);
        blockSelectionSort(arr, M);
        print(arr);

        for (int i = 0; i <= N / M - 2; i++) {
            merge(arr, i * M, (i + 2) * M - 1);
        }
        print(arr);
    }

    public static void print(Comparable[] a) {
        for (Comparable i : a) {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }

    public static void merge(Comparable[] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        Comparable[] aux = new Comparable[mid - lo + 1];
        for (int i = lo; i <= mid; i++) {
            aux[i - lo] = a[i];
        }
        int j = 0;
        int k = mid + 1;
        for (int i = lo; i <= hi && j < aux.length; i++) {
            if (k > hi)
                a[i] = aux[j++];
            else if (aux[j].compareTo(a[k]) < 0)
                a[i] = aux[j++];
            else
                a[i] = a[k++];
        }
    }

    public static void blockSelectionSort(Comparable[] a, int size) {
        int n = a.length;
        for (int i = 0; i < a.length / size; i++) {
            int min = i;
            for (int j = i; j < a.length / size; j++) {
                if (a[j * size].compareTo(a[min * size]) < 0)
                    min = j;
            }
            //swipe the whole block instead of swipe a single element
            for (int k = 0; k < size; k++) {
                Comparable temp = a[i * size + k];
                a[i * size + k] = a[min * size + k];
                a[min * size + k] = temp;
            }
        }
    }
}
