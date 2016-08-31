import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
when N becomes bigger, the chances there are matches numbers between two random array grows,
 */

public class ex_1_1_39 {
    public static void main(String[] args) {
        StdOut.print("Input trails times T: ");
        int T = StdIn.readInt();
        int[][] rt = new int[T][6 - 3 + 1];
        for (int i = 0; i < T; i++) {
            for (int j = 3; j <= 6; j++) {
                rt[i][j - 3] = binarySearchClient((int) Math.pow(10, j));
            }
        }
        for (int i = 0; i < rt.length; i++) {
            for (int j = 0; j < rt[0].length; j++) {
                StdOut.print(rt[i][j] + " ");
            }
            StdOut.println();
        }
    }

    private static int binarySearchClient(int N) {
        int count = 0;
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(10000000);
            b[i] = StdRandom.uniform(10000000);
        }
        for (int i = 0; i < N; i++) {
            if (BinarySearch.indexOf(b, a[i]) != -1)
                count++;
        }
        return count;
    }
}