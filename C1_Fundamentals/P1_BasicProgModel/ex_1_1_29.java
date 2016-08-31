import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.util.Arrays;

/*
If i and j are the values returned byrank(key, a)andcount(key, a)respectively,thena[i..i+j-1]arethevaluesin the array that are equal to key.
 */

public class ex_1_1_29 {
    public static void main(String[] args) {
        int[] whitelist = new In(new File("TestData/tinyT.txt")).readAllInts();
        Arrays.sort(whitelist);
        StdOut.print("Input the key to search: ");
        int key = StdIn.readInt();
        StdOut.println(count(whitelist, key));
        StdOut.println(rank(whitelist, key));
    }

    public static int count(int[] a, int key) {
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key)
                c++;
        }
        return c;
    }

    public static int rank(int[] a, int key) {
        int lo = 0;
        int hi = a.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < key)
                lo = mid + 1;
            else if (a[mid] > key)
                hi = mid - 1;
            else {
                int rt = mid;
                while (rt - 1 >= 0 && a[rt] == a[mid]) {
                    rt--;
                }
                return rt;
            }
        }
        return -1;
    }
}