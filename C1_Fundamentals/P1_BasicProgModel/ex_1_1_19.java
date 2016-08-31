import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
better implementation of F(N) that saves computed values in an array.
 */
public class ex_1_1_19 {
    public static void main(String[] args) {
        StdOut.print("Input N: ");
        int N = StdIn.readInt();
        long[] a = new long[N];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < N; i++) {
            a[i] = a[i - 1] + a[i - 2];
            StdOut.println(i + " " + a[i]);
        }
    }
}