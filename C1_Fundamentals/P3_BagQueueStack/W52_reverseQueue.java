package P3_BagQueueStack;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 9/18/16.
 */
public class W52_reverseQueue {
    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Queue<Integer> q = new Queue<>();
        for (Integer i : input)
            q.enqueue(i);
        StdOut.print(reverse(q).toString());
    }

    public static Queue<Integer> reverse(Queue<Integer> q) {
        if (!q.isEmpty()) {
            Integer first = q.dequeue();
            reverse(q).enqueue(first);
        }
        return q;
    }
}
