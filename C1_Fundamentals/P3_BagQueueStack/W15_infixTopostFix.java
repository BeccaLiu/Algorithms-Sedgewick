package P3_BagQueueStack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by rliu on 9/7/16.
 */
public class W15_infixTopostFix {
    public static void main(String[] args) {
        Stack<String> vals = new Stack<String>();
        Stack<String> operation = new Stack<String>();
        Map<String, Integer> precedence = new TreeMap<String, Integer>();
        precedence.put("(", 0);
        precedence.put(")", 0);
        precedence.put("-", 1);
        precedence.put("+", 1);
        precedence.put("/", 2);
        precedence.put("*", 2);
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!precedence.containsKey(s)) {
                vals.push(s);
                continue;
            }

            while (true) {
                if (operation.isEmpty() || s.equals("(") || precedence.get(s) > precedence.get(operation.peek())) {
                    operation.push(s);
                    break;
                }
                String op = operation.pop();
                if (op.equals("(")) {
                    String temp = vals.pop();
                    vals.push("( " + temp + " )");
                    break;
                } else {
                    String val2 = vals.pop();
                    String val1 = vals.pop();
                    vals.push(val1 + " " + val2 + " " + op);

                }
            }
        }

        while (!operation.isEmpty()) {
            String op = operation.pop();
            String val2 = vals.pop();
            String val1 = vals.pop();
            vals.push(val1 + " " + val2 + " " + op);
        }
        StdOut.println(vals.pop());
    }
}
