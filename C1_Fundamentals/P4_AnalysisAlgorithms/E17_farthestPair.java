package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by yuexiliu on 9/27/16.
 */
public class E17_farthestPair {
    public static void main(String[] args) {
        double[] a = new In("TestData/closetPair.txt").readAllDoubles();
        Arrays.sort(a); //nlogn
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
            if (a[i] < min)
                min = a[i];

        }
        StdOut.print(min + "," + max + ":" + (max - min));
    }
}
