package P3_BagQueueStack;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 9/4/16.
 * ex 1.3.37
 */
public class Josephus {
    public static void main(String[] args) {
        int N = 7;
        int M = 2;
        Queue<Integer> q = new Queue<>();
        for (int i = 0; i < N; i++) {
            q.enqueue(i);
        }
        while (!q.isEmpty()) {
            for (int j = 1; j < M; j++) {
                q.enqueue(q.dequeue());
            }
            StdOut.print(q.dequeue() + " ");
        }
    }
}
