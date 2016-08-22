import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
if using this bad shuffling, the output with M=3, N=1000000 will be like
    0      1       2
 0  333913 333252 332835
 1  370989 295541 333470
 2  295098 371207 333695

 as shuffling with random position between 0,2
 it will be 27 possible outcomes, but
123 - 4 times
132 - 5 times
213 - 5 times
231 - 5 times
312 - 4 times
321 - 4 times
=============
     27 times total

after shuffling 123, you are more likely to get 132, 213, 231
 */
public class ex_1_1_37 {
    public static void main(String[] args) {
        int M = 3;
        int N = 1000000;
        int[] arr = new int[M];
        int[][] rt = new int[M][M];
        for (int i = 0; i < N; i++) {
            initial(arr);
            badShuffle(arr);
            for (int j = 0; j < arr.length; j++) {
                rt[arr[j]][j]++;
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                StdOut.printf("%7d", rt[i][j]);
            }
            StdOut.println();
        }

    }

    private static void badShuffle(int[] a) {
        if (a == null) throw new NullPointerException("argument array is null");
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = StdRandom.uniform(n);     // between 0 and n-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    private static void initial(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }
}