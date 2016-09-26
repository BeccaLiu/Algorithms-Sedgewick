package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by rliu on 9/25/16.
 */
public class E11_SETofInts {
    private int[] a;

    public E11_SETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            a[i] = keys[i]; // defensive copy
        Arrays.sort(a);
    }

    public static void main(String[] args) {
        In in = new In("TestData/tinyT.txt");
        E11_SETofInts ints = new E11_SETofInts(in.readAllInts());
        StdOut.println(ints.howMany(98));

    }

    public int howMany(int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < key)
                lo = mid + 1;
            else if (a[mid] > key)
                hi = mid - 1;
            else {
                int count = 1;
                int temp = mid;
                while (temp > 0 && a[temp - 1] == key) {
                    temp--;
                    count++;
                }
                while (mid < a.length - 1 && a[mid + 1] == key) {
                    mid++;
                    count++;
                }
                return count;
            }
        }
        return -1; //if not found
    }
}
