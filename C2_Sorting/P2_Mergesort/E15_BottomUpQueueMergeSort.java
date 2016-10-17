package P2_Mergesort;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/16/16.
 */
public class E15_BottomUpQueueMergeSort {
    public static void main(String[] args) {
        Queue<Queue<Integer>> queues = new Queue<>();
        int size = 50;
        IntStream.range(0, size).forEach(i -> {
            Queue<Integer> q = new Queue<Integer>();
            q.enqueue(StdRandom.uniform(100));
            queues.enqueue(q);
        });
        sort(queues);
        StdOut.print(queues.dequeue());
    }

    public static void sort(Queue<Queue<Integer>> a) {
        while (a.size() > 1)
            a = merge(a);
    }

    public static Queue<Queue<Integer>> merge(Queue<Queue<Integer>> a) {
        Queue<Integer> q1 = a.dequeue();
        Queue<Integer> q2 = a.dequeue();
        Queue<Integer> rs = new Queue<>();
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q1.isEmpty()) rs.enqueue(q2.dequeue());
            else if (q2.isEmpty()) rs.enqueue(q1.dequeue());
            else if (q1.peek().compareTo(q2.peek()) < 0)
                rs.enqueue(q1.dequeue());
            else
                rs.enqueue(q2.dequeue());
        }
        a.enqueue(rs);
        return a;
    }
}
