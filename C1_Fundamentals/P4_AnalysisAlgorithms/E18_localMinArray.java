package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 9/28/16.
 */
public class E18_localMinArray {
    public static void main(String[] args) {
        int[] a = new int[50];
        for (int i = 0; i < a.length; i++)
            a[i] = i;
        StdRandom.shuffle(a);
        int low = 0;
        int high = a.length;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) {
                index = mid;
                break;
            } else if (a[mid - 1] < a[mid] && a[mid] < a[mid + 1])
                high = mid - 1;
            else if (a[mid - 1] > a[mid] && a[mid] > a[mid + 1])
                low = mid + 1;
        }
        if (index != -1)
            StdOut.println(a[index - 1] + " " + a[index] + " " + a[index + 1]);
    }
}
