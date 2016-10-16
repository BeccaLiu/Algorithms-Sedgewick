package P2_Mergesort;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by rliu on 10/16/16.
 */
public class E14_MergeSortedQueue {
    public static void main(String[] args) {
        int size = 20;
        Queue<Integer> q1 = new Queue<>();
        Queue<Integer> q2 = new Queue<>();
        int[] arr = new int[size];
        IntStream.range(0, size).parallel().forEach(i -> {
            arr[i] = StdRandom.uniform(100);
        });
        Arrays.sort(arr);
        for (int i : arr)
            q1.enqueue(i);
        StdOut.println(q1);
        IntStream.range(0, size).parallel().forEach(i -> {
            arr[i] = StdRandom.uniform(100);
        });
        Arrays.sort(arr);
        for (int i : arr)
            q2.enqueue(i);
        StdOut.println(q2);
        StdOut.print(merge(q1, q2));

    }

    public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> rs = new Queue<Integer>();
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q1.isEmpty()) rs.enqueue(q2.dequeue());
            else if (q2.isEmpty()) rs.enqueue(q1.dequeue());
            else if (q1.peek().compareTo(q2.peek()) < 0) rs.enqueue(q1.dequeue());
            else rs.enqueue(q2.dequeue());
        }
        return rs;
    }
}
