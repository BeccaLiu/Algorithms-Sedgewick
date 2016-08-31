/*
Write a code fragment that puts the binary representation of a positive integer N into a String s
*/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ex_1_1_9 {
    public static void main(String[] args) {
        StdOut.print("input N: \n");
        int N = StdIn.readInt();
        String output = "";
        for (int n = N; n > 0; n /= 2) {
            output = n % 2 + output;
        }
        StdOut.print(output);
    }
}
