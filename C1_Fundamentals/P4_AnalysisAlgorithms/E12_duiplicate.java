package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Created by rliu on 9/25/16.
 */
public class E12_duiplicate {
    public static void main(String[] args) {
        int[] a = generateArr(10);
        int[] b = generateArr(15);
        int i = 0;
        int j = 0;
        StdOut.println(Arrays.toString(a));
        StdOut.println(Arrays.toString(b));
        for (; i < a.length; ) {
            while (i < a.length && j < b.length && a[i] < b[j]) {
                i++;
            }
            while (i < a.length && j < b.length && a[i] > b[j]) {
                j++;
            }
            if (i < a.length && j < b.length && a[i] == b[j]) {
                StdOut.print(a[i] + " ");
                i++;
                j++;
            }
        }

    }

    public static int[] generateArr(int size) {
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = StdRandom.uniform(30);
        }
        Arrays.sort(temp);
        return temp;
    }
}
