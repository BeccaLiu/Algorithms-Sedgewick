package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 9/27/16.
 */
public class TestDataGenerator {
    public static void main(String[] args) {
        closestPairOneDimension();
    }

    public static void intForXSumProb() {
        Out out = new Out("TestData/sumNumber.txt");
        for (int i = 0; i < 100; i++) {
            out.println(StdRandom.uniform(-50, 50));
        }
    }

    public static void closestPairOneDimension() {
        Out out = new Out("TestData/closetPair.txt");
        for (int i = 0; i < 100; i++) {
            out.println(StdRandom.uniform(-50.0, 50.0));
        }
    }
}
