package C3_BagQueueStack;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 8/31/16.
 */
public class ex_1_3_15 {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }
        int count = 0;
        while (true) {
            if (count == q.size() - k) {
                StdOut.print(q.dequeue());
                break;
            }
            q.dequeue();
            count++;
        }
    }
}
