import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ex_1_1_27 {

    public static void main(String[] args) {
        StdOut.print("Input N: ");
        int N = StdIn.readInt();
        StdOut.print("Input K: ");
        int K = StdIn.readInt();
        StdOut.print("Input p: ");
        float p = StdIn.readFloat();

        StdOut.println(binomial(N, K, p));
        double[][] array = new double[N + 1][K + 1];
        array[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            array[i][0] = (1 - p) * array[i - 1][0];
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                array[i][j] = (1 - p) * array[i - 1][j] + p * array[i - 1][j - 1];
            }
        }
        StdOut.print(array[N][K]);

    }

    private static double binomial(int N, int k, double p) { //recursive slow
        if (N == 0 && k == 0)
            return 1.0;
        if (N < 0 || k < 0)
            return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

}