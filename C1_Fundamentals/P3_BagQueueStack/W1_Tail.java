package P3_BagQueueStack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * Created by rliu on 9/7/16.
 * Write a program Tail so that Tail k < file.txt prints the last k lines of the file file.txt. Use StdIn.readLine(). Which data structure should you use?
 * http://algs4.cs.princeton.edu/13stacks/
 * take the hint of web exercise 7, we can also using queue.
 */
public class W1_Tail {
    public static void main(String[] args) {
        In in = new In(new File("TestData/amendments.txt"));
        Stack<String> s = new Stack<>(); //using stack will print the last k lines backwards
        while (!in.isEmpty()) {
            s.push(in.readLine());
        }
        int i = 0;
        while (i < 10) {
            StdOut.println(s.pop());
            i++;
        }

        queueImplementation();
    }

    public static void queueImplementation() { //using queue will print the last k lines in order
        In in = new In(new File("TestData/amendments.txt"));
        Queue<String> q = new Queue<String>();
        while (!in.isEmpty()) {
            q.enqueue(in.readLine());
            if (q.size() == 10)
                q.dequeue();
        }

        while (!q.isEmpty()) {
            StdOut.println(q.dequeue());
        }
    }
}
