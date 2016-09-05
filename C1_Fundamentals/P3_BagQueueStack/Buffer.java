package P3_BagQueueStack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 9/4/16.
 * hint: using two stacks
 */
public class Buffer {
    Stack<Character> left; //all the character in the left side of cursor
    Stack<Character> right; //all the character in the right side of cursor
    int N;

    public Buffer() {
        left = new Stack<Character>();
        right = new Stack<Character>();
        N = 0;
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        while (!StdIn.isEmpty()) {
            buffer.insert(StdIn.readChar());
        }
        buffer.left(4);
        buffer.delete();
        StdOut.println(buffer);

    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(char c) {
        left.push(c);
        N++;
    }

    public char delete() {
        N--;
        return left.pop();
    }

    public void left(int k) {
        int i = 0;
        while (i < k && !left.isEmpty()) {
            right.push(left.pop());
            i++;
        }
    }

    public void right(int k) {
        int i = 0;
        while (i < k && !right.isEmpty()) {
            left.push(right.pop());
            i++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char c : left) {
            sb.insert(0, c);
        }
        for (char c : right) {
            sb.append(c);
        }
        return sb.toString();
    }
}
