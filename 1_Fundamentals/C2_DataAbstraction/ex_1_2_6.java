package C2_DataAbstraction;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 8/27/16.
 */
public class ex_1_2_6 {
    public static void main(String[] args) {
        StdOut.print("input first string: ");
        String a = StdIn.readString();
        StdOut.print("input second String: ");
        String b = StdIn.readString();
        StdOut.println(checkRotation(a, b));
    }

    public static boolean checkRotation(String a, String b) {
        if (a.length() != b.length())
            return false;
        String c = a + a;
        int j = 0;
        boolean matched = false;
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) == b.charAt(j)) {
                if (j == b.length() - 1) {
                    matched = true;
                    break;
                }
                j++;
            } else
                j = 0;
        }
        return matched;
    }

    public static boolean circularRotation(String a, String b) {
        return (a + a).contains(b);
    }
}
