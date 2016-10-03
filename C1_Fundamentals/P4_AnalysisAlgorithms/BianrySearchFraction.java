package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 10/2/16
 * Binary search for a fraction. Devise a method that uses a logarithmic number of queries of the form Is the number less than x? to find a rational number p/q such that 0 < p < q < N. Hint : Two fractions with denominators less than N cannot differ by more than 1/N 2.
 * the problem is described vaguely
 * the question should be given a x between [0,1], find a p/q where (0<p<q<N) and the difference between x and p/q should not larger than 1/N^2
 */
public class BianrySearchFraction {
    public static void main(String[] args) {
        double x = 0.0625;
        int N = 100; //precision
        binarySearchFraction(x, N);
        x = StdRandom.uniform(0.0, 1.0);
        StdOut.println(x);
        binarySearchFraction(x, N);
    }

    public static void binarySearchFraction(double x, int N) {
        int lowP = 0;
        int lowQ = 0;
        int highP = 1;
        int highQ = 1;
        int p = 1;
        int q = 1;
        while (p < N && q < N) {

            if (x == (double) p / q || Math.abs(x - (double) p / q) < 1 / Math.pow(N, 2)) {
                break;
            } else if (x < (double) p / q) {
                highP = p;
                highQ = q;
            } else {
                lowP = p;
                lowQ = q;
            }

            if (lowQ == 0) {
                p = highP;
                q = highQ * 2;

            } else {
                int gcd = gcd(lowQ, highQ);
                int deno = (lowQ * highQ) / gcd;
                p = highP * (deno / highQ) + lowP * (deno / lowQ);
                q = deno * 2;
            }
        }

        StdOut.println(p + "/" + q);
    }

    public static int gcd(int i, int j) {
        if (j == 0) return i;
        int mod = i % j;
        return gcd(j, mod);
    }
}
