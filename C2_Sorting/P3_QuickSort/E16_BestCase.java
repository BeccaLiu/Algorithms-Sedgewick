package P3_QuickSort;

import edu.princeton.cs.algs4.StdOut;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/20/16.
 * Best case will partition the array in half each time
 */
public class E16_BestCase {
    public static void main(String[] args) {
        int N = 50;
        int[] bestCase = new int[N];
        IntStream.range(0, N).forEach(i -> bestCase[i] = i);
        //the input can be any sorted array, and produceBestCase will turn this array into the best case arrangement.
        produceBestCase(bestCase, 0, bestCase.length - 1);
        IntStream.range(0, N).forEach(i -> StdOut.print(bestCase[i] + " "));

    }

    public static void produceBestCase(int[] best, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;
        exch(best, lo, mid);
        produceBestCase(best, lo + 1, mid - 1);
        produceBestCase(best, mid + 1, hi);
    }

    public static void exch(int[] best, int i, int j) {
        int temp = best[i];
        best[i] = best[j];
        best[j] = temp;
    }
}
