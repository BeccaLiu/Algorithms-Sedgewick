package C3_BagQueueStack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 8/30/16.
 */
public class ex_1_3_10 {
    public static void main(String[] args) {
        StdOut.print("Input Expression: ");
        StdOut.print(InfixToPostFix(StdIn.readLine()));
    }

    public static String InfixToPostFix(String s) {
        String[] input = s.split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            String c = input[i];
            if (c.equals(")")) {
                String exp1 = stack.pop();
                String operation = stack.pop();
                String exp2 = stack.pop();
                String temp = new StringBuffer().append(exp2).append(exp1).append(operation).toString();
                stack.push(temp);
            } else if (!c.equals("(")) {
                stack.push(input[i]);
            }
        }
        return stack.toString();
    }
}
