package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 9/27/16.
 */
public class NumForSumProb {
    public static void main(String[] args) {
        Out out = new Out("TestData/sumNumber.txt");
        for (int i = 0; i < 100; i++) {
            out.println(StdRandom.uniform(-50, 50));
        }
    }
}
