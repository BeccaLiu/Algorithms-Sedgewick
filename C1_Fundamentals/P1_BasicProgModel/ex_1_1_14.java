import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Write a static method lg() that takes an int value N as argument and returns the largest int not larger than the base-2 logarithm of N. Do not use Math.
 */
public class ex_1_1_14 {
    public static void main(String[] args) {
        StdOut.print("Input N: ");
        int N = StdIn.readInt();
        StdOut.print("Input Base: ");
        int base = StdIn.readInt();
        StdOut.println(lg(N, base));
    }

    public static int lg(int N, int base) {
        int index = 0;
        while (N >= base) {
            N /= base;
            index++;
        }
        return index;
    }
}