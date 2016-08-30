package C3_BagQueueStack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 8/30/16.
 */
public class ex_1_3_9 {
    public static void main(String args[]) {
        StdOut.print("Input expression: ");
        String[] input = StdIn.readLine().split(" ");
        Stack<String> s = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            String c = input[i];
            if (c.equals(")")) {
                String exp1 = s.pop();
                String operation = s.pop();
                String exp2 = s.pop();
                String temp = new StringBuffer("(").append(exp2).append(operation).append(exp1).append(")").toString();
                s.push(temp);
            } else {
                s.push(c);
            }
        }

        StdOut.print(s);
    }
}
