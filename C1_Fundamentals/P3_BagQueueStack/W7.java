package P3_BagQueueStack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * Created by rliu on 9/7/16.
 * Given a stack of an unknown number of strings, print out the 5th to the last one. It's OK to destroy the stack in the process.
 */
public class W7 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        In in = new In(new File("TestData/tinyT.txt"));
        while (!in.isEmpty()) {
            s.push(in.readInt());
        }
        Queue<Integer> q = new Queue<>();
        while (!s.isEmpty()) {
            q.enqueue(s.pop());
            if (q.size() == 5)
                StdOut.println(q.dequeue());
        }
    }

}
