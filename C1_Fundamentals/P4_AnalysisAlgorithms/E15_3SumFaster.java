package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by rliu on 9/27/16.
 */
public class E15_3SumFaster {
    public static void main(String[] args) {

        int[] arr = new In("TestData/sumNumber.txt").readAllInts();
        Arrays.sort(arr);
        int N = arr.length;
        int cnt = 0;
        for (int i = 0; i < N - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            int m = i + 1;
            int n = N - 1;
            while (m < n) {
                if (m > i + 1 && arr[m] == arr[m - 1]) {
                    m++;
                    continue;
                }
                if (arr[i] + arr[m] + arr[n] > 0)
                    n--;
                else if (arr[i] + arr[m] + arr[n] < 0)
                    m++;
                else {
                    StdOut.println(arr[i] + " " + arr[m] + " " + arr[n]);
                    cnt++;
                    m++;
                    n--;
                }
            }
        }
        StdOut.println(cnt);
    }
}
