package P3_BagQueueStack;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 9/7/16.
 */
public class W10_Palindrome {
    public static void main(String[] args) {
        String s = StdIn.readLine();
        StdOut.println(palindromeChecker(s));
    }

    public static boolean palindromeChecker(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> q = new Queue<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                stack.push(Character.toLowerCase(c));
                q.enqueue(Character.toLowerCase(c));
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != q.dequeue())
                return false;
        }
        return true;
    }
}
