package P3_BagQueueStack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 8/30/16.
 */
public class ex_1_3_12 {
    public static void main(String[] args) {
        Stack<String> s = new Stack();
        while (!StdIn.isEmpty()) {
            s.push(StdIn.readString());
        }
        StdOut.print(copy(s));
    }

    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> newStack = new Stack<String>();
        for (String s : stack)
            newStack.push(s);
        return newStack;
    }
}
