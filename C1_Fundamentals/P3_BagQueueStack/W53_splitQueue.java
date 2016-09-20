package P3_BagQueueStack;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 9/19/16.
 */
public class W53_splitQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        for (int i = 0; i < 15; i++) {
            q.enqueue(StdRandom.uniform(100));
        }
        StdOut.println(q.toString());
        Queue<Integer> q1 = new Queue<>();
        Queue<Integer> q2 = new Queue<>();
        for (int i = 0; i < q.size(); i++) {
            int temp = q.dequeue();
            if (temp % 2 == 0)
                q1.enqueue(temp);
            else
                q2.enqueue(temp);

            q.enqueue(temp);
        }
        StdOut.println(q1);
        StdOut.println(q2);
    }
}
