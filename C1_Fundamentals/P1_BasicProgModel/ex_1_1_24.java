import edu.princeton.cs.algs4.StdOut;

/*
compute the greatest common divisor
 */
public class ex_1_1_24 {
    public static void main(String[] args) {
        StdOut.print("GDC is " + euclid(1234567, 1111111));
    }

    private static int euclid(int p, int q) {
        StdOut.println(p + " " + q);
        if (q == 0) return p;
        int r = p % q;
        return euclid(q, r);
    }

}