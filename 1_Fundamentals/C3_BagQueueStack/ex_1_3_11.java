package C3_BagQueueStack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 8/30/16.
 * *  Known bugs
 * ----------
 * - No error checking - assumes input is legal postfix expression.
 * - All token must be separated by whitespace, e.g., 1 5+ is illegal.
 */
public class ex_1_3_11 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if (s.equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if (s.equals("-")) {
                int a = stack.pop();
                stack.push(stack.pop() - a);
            } else if (s.equals("/")) {
                int a = stack.pop();
                stack.push(stack.pop() / a);
            } else
                stack.push(Integer.parseInt(s));
        }
        StdOut.print(stack);
    }
}
