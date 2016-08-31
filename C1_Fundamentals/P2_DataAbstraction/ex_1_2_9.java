package P2_DataAbstraction;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.util.Arrays;

/**
 * Created by rliu on 8/27/16.
 */
public class ex_1_2_9 {
    public static int rank(int key, int[] a, Counter c) {  // Array must be sorted.
        c.increment();
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {  // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = new In(new File("TestData/tinyT.txt")).readAllInts();
        Arrays.sort(whitelist);

        Counter c = new Counter("numbers");
        while (!StdIn.isEmpty()) {  // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            if (rank(key, whitelist, c) < 0)
                StdOut.println(key);
        }
        StdOut.println(c);

    }
}
