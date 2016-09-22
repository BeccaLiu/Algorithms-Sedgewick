package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by rliu on 9/21/16.
 */
public class E8_equalValue {
    public static void main(String[] args) {
        In in = new In("TestData/bigT.txt");
        String[] s = in.readAllLines();
        Arrays.sort(s);
        for (int i = 1; i < s.length; i++) {
            int pairs = 0;
            while (s[i].equals(s[i - 1])) {
                i++;
                pairs++;
            }
            StdOut.println(s[i - 1] + ":" + pairs);
        }
    }
}
