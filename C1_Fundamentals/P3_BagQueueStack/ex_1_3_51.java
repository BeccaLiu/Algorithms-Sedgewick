package P3_BagQueueStack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.TreeMap;

/**
 * Created by rliu on 9/6/16.
 * Evaluates arithmetic expressions using Dijkstra's two-stack algorithm.
 * Handles the following binary operators: +, -, *, / and parentheses.
 * <p>
 * % echo "3 * 1 * ( 5 * 6 - 7 * 3 ) * ( 8 - 5 * 2 )" | java EvaluateDeluxe
 * 3.0 * 1.0
 * 5.0 * 6.0
 * 7.0 * 3.0
 * 30.0 - 21.0
 * 3.0 * 9.0
 * 5.0 * 2.0
 * 8.0 - 10.0
 * -54
 */
public class ex_1_3_51 {
    public static void main(String[] args) {
        TreeMap<String, Integer> precedence = new TreeMap<String, Integer>();
        precedence.put("(", 0);   // for convenience with algorithm
        precedence.put(")", 0);
        precedence.put("+", 1);   // + and - have lower precedence than * and /
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);

        Stack<String> operation = new Stack();
        Stack<Double> operand = new Stack();
        while (!StdIn.isEmpty()) { //calculate * and / first, and then calculate everything inside (), that's why +- have higher precedence than ()
            String s = StdIn.readString();


            if (!precedence.containsKey(s)) {//if it is a number, push and read next
                operand.push(Double.parseDouble(s));
                continue;
            }
            while (true) {
                if (operation.isEmpty() || s.equals("(") || precedence.get(s) > precedence.get(operation.peek())) { //if no more operation or s is (
                    operation.push(s);
                    break;
                }
                String op = operation.pop(); //operation is not empty and operation has higher or equal precedence than the current s
                if (op.equals("(")) {
                    assert (s.equals(")"));//only stop while loop when you meet the left parentheses
                    break;
                } else {
                    double val2 = operand.pop();
                    double val1 = operand.pop();
                    operand.push(eval(op, val1, val2));
                    StdOut.println(val1 + " " + op + " " + val2);
                }
            }
        }

        while (!operation.isEmpty()) {
            double val2 = operand.pop();
            double val1 = operand.pop();
            operand.push(eval(operation.pop(), val1, val2));
        }

        StdOut.print("Ret: " + operand.pop());
    }

    public static double eval(String op, double val1, double val2) {
        if (op.equals("+")) return val1 + val2;
        else if (op.equals("-")) return val1 - val2;
        else if (op.equals("*")) return val1 * val2;
        else if (op.equals("/")) return val1 / val2;
        else throw new RuntimeException("Invalid Operation");
    }
}
