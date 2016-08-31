import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Array exercise. Write a code fragment that creates an N-by-N boolean array a[][] such that a[i][j] is true if i and j are relatively prime (have no common factors), and false otherwise.
 */
public class ex_1_1_30 {
    public static void main(String[] args) {
        StdOut.print("Input N: ");
        int N = StdIn.readInt();
        boolean[][] arr = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++)
                arr[i][j] = prime(i, j);
        }

        StdOut.print("");
        for (int i = 0; i < N; i++)
            StdOut.printf("%7d", i);
        StdOut.println();
        for (int i = 0; i < N; i++) {
            StdOut.printf("%d", i);
            for (int j = 0; j < N; j++) {
                if (j < i) {
                    arr[i][j] = arr[j][i];
                }
                StdOut.printf("%7s", arr[i][j]);
            }
            StdOut.println();
        }
    }

    private static boolean prime(int i, int j) {
        return gcd(j, i) == 1;
    }

    private static int gcd(int i, int j) {
        if (j == 0) return i;
        int mod = i % j;
        return gcd(j, mod);
    }
}