package C3_BagQueueStack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 8/29/16.
 */
public class ex_1_3_4 {
    private static boolean isBalanced(String input) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '{' || c == '[' || c == '(')
                s.push(c);
            else if (c == '}' && s.pop() != '{')
                return false;
            else if (c == ']' && s.pop() != '[')
                return false;
            else if (c == ')' && s.pop() != '(')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StdOut.print("Input String to check : ");
        String s = StdIn.readString();
        StdOut.print(isBalanced(s));
    }
}
