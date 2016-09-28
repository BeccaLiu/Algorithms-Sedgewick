package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by rliu on 9/27/16.
 */
public class E14_4Sum {
    public static void main(String[] args) {
        int[] a = new In("TestData/tinyT.txt").readAllInts();
        if (a.length < 4)
            throw new IllegalStateException("array size is smaller than 4");
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; i < a.length; j++)
                for (int m = j + 1; m < a.length; m++)
                    for (int n = m + 1; n < a.length; n++)
                        if (a[i] + a[j] + a[m] + a[n] == 0)
                            StdOut.println(a[i] + " " + a[j] + " " + a[m] + " " + a[n]);
    }
}
