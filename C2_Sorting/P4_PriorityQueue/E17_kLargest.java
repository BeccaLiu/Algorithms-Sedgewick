package P4_PriorityQueue;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/25/16.
 * <p>
 * when delMin in the loop it delete the first N-K smallest number
 */
public class E17_kLargest {
    public static void main(String[] args) {
        int N = 15;
        int k = StdRandom.uniform(15);
        Integer[] arr = new Integer[N];
        IntStream.range(0, N).forEach(i -> arr[i] = StdRandom.uniform(100));
        IntStream.range(0, N).forEach(i -> StdOut.print(arr[i] + " "));

        StdOut.println("k:" + k);
        MinPQ<Integer> pq = new MinPQ<>();
        for (int i = 0; i < k; i++) {
            pq.insert(arr[i]);
            StdOut.println(pq);
        }
        for (int i = k; i < N; i++) {
            pq.insert(arr[i]);
            pq.delMin();
            StdOut.println(pq);
        }

        java.util.Arrays.sort(arr);
        IntStream.range(0, N).forEach(i -> arr[i] = StdRandom.uniform(100));

    }
}
