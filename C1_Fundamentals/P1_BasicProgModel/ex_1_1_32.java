import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ex_1_1_32 {
    public static void main(String[] args) {
        StdOut.print("input the range l: ");
        double l = StdIn.readDouble();
        StdOut.print("input the range r: ");
        double r = StdIn.readDouble();
        StdOut.print("input N: ");
        int N = StdIn.readInt();
        double[] randomDouble = new double[N * N * N];
        for (int i = 0; i < randomDouble.length; i++) {
            randomDouble[i] = StdRandom.uniform(l, r);
        }
        makeHistogram(randomDouble, l, r, N);
    }

    private static void makeHistogram(double[] input, double l, double r, int N) {
        int[] histogram = new int[N];
        double interval = (r - l) / N;
        for (int i = 0; i < input.length; i++) {
            histogram[(int) Math.floor((input[i] - l) / interval)]++;
        }
        StdDraw.setXscale(l, r);
        StdDraw.setYscale(0, input.length / N * 1.5);
        for (int i = 0; i < N; i++) {
            StdDraw.filledRectangle(l + interval / 2 + interval * i, histogram[i] / 2, 0.8 * interval / 2, histogram[i] / 2);
        }
    }
}