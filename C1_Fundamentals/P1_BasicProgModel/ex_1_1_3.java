import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ex_1_1_3 {
    public static void main(String[] args) {
        int a, b, c;
        a = b = c = 0;
        StdOut.print("input three character: \n");
        a = StdIn.readInt();
        b = StdIn.readInt();
        c = StdIn.readInt();
        if (a == b && b == c)
            StdOut.print("equal");
        else
            StdOut.print("not equal");
    }
}