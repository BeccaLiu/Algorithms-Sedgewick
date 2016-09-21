package P3_BagQueueStack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

/**
 * Created by rliu on 9/20/16.
 * https://en.wikipedia.org/wiki/Shunting-yard_algorithm
 * infix to postfix
 * 3 + 4 * 2 / ( 1 - 5 )
 * 3 4 2 * 1 5 - / +
 */
public class W60_ShuntingYard {
    public static void main(String[] args) {
        StdOut.println("input infix expression:");
        String[] input = StdIn.readLine().split(" ");
        Stack<String> operation = new Stack<String>();
        HashMap<String, Integer> precedence = new HashMap<>();
        precedence.put("(", 1);
        precedence.put(")", 1);
        precedence.put("+", 2);
        precedence.put("-", 2);
        precedence.put("*", 3);
        precedence.put("/", 3);
        StringBuilder output = new StringBuilder();

        for (String s : input) {
            if (s.equals("(")) {
                operation.push(s);
            } else if (s.equals(")")) {
                while (!operation.peek().equals("(")) {
                    output.append(operation.pop() + " ");
                }
                operation.pop();//discard matching parenthesis
            } else if (precedence.containsKey(s)) {
                while (!operation.isEmpty() && precedence.get(operation.peek()) >= precedence.get(s)) {
                    output.append(operation.pop() + " ");
                }
                operation.push(s);
            } else {
                output.append(s + " ");
            }
        }
        while (!operation.isEmpty()) {
            output.append(operation.pop() + " ");
        }
        StdOut.println(output);
    }
}
