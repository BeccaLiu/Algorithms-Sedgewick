package P3_BagQueueStack;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 9/7/16.
 */
public class W8_tagSystems {
    public static void main(String[] args) {
        Queue<Character> q = new Queue<Character>();
        String s = StdIn.readString();
        for (Character c : s.toCharArray()) {
            q.enqueue(c);
        }

        while (q.size() >= 3) {
            Character c = q.peek();
            q.dequeue();
            q.dequeue();
            q.dequeue();
            if (c == '0') {
                q.enqueue('0');
                q.enqueue('0');
            } else {
                q.enqueue('1');
                q.enqueue('1');
                q.enqueue('0');
                q.enqueue('1');
            }
            StdOut.println(q);
        }
        StdOut.print(q);
    }
}
