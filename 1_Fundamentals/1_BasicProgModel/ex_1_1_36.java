import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ex_1_1_36 {
    public static void main(String[] args) {
        StdOut.println("input M: ");
        int M = StdIn.readInt();
        StdOut.println("input N: ");
        int N = StdIn.readInt();
        int[] arr = new int[M];
        int[][] rt = new int[M][M];
        for (int i = 0; i < N; i++) {
            initial(arr);
            StdRandom.shuffle(arr);
            for (int j = 0; j < arr.length; j++) {
                rt[j][arr[j]]++;
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                StdOut.printf("%3d", rt[i][j]);
            }
            StdOut.println();
        }
    }

    private static void initial(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }
}