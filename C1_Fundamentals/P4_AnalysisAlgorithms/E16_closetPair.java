package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by yuexiliu on 9/27/16.
 * time complexity is nlogn for sort and n for find closetpair
 * total time complexity is nlogn, linearithmic
 */
public class E16_closetPair {
    public static void main(String[] args) {
        double[] a = new In("TestData/closetPair.txt").readAllDoubles();
        Arrays.sort(a); //nlogn
        double min = Double.POSITIVE_INFINITY;
        double x = Double.NaN;
        double y = Double.NaN;
        for (int i = 1; i < a.length; i++) { //n
            if (a[i] == a[i - 1])
                continue;
            if (a[i] - a[i - 1] < min) {
                min = a[i] - a[i - 1];
                x = a[i - 1];
                y = a[i];
            }
        }
        StdOut.print(x + "," + y);
    }
}
