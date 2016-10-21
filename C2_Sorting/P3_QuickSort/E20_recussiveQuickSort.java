package P3_QuickSort;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/21/16.
 */
public class E20_recussiveQuickSort {
    public static void sort(int[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    //turn this method from recursive to non-recursive method
    public static void sort(int[] a, int lo, int hi) {
        if (a == null || a.length <= 1 || isSorted(a)) //assert the array is not empty or just have one item or it is sorted
            return;
        Stack<Integer> s = new Stack<Integer>();

        s.push(0);
        s.push(a.length - 1);

        while (!s.isEmpty()) {
            int right = s.pop();
            int left = s.pop();
            int p = partition(a, left, right);
            if (left < p - 1) {
                s.push(left);
                s.push(p - 1);
            }
            if (p + 1 < right) {
                s.push(p + 1);
                s.push(right);
            }
        }
    }

    public static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v)
                if (i >= hi)
                    break;
            while (v < a[--j])
                if (j <= lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, j, lo);
        return j;
    }

    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i + 1])
                return false;
        }
        return true;
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
        IntStream.range(0, size).forEach(i -> StdOut.print(a[i] + " "));

    }
}
