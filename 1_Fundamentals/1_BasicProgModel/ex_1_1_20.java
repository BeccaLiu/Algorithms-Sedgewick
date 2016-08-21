import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Write a recursive static method that computes the value of ln(N!)
N!=N*(N-1)*(N-2)*....*1
ln(A*B)=lnA+lnB
 */
public class ex_1_1_20 {
    public static void main(String[] args) {
        StdOut.println("Input N: ");
        int N = StdIn.readInt();
        StdOut.print(factorialLn(N));
    }

    private static double factorialLn(int N) {
        if (N == 1) return 0;
        return Math.log(N) + factorialLn(N - 1);
    }
}