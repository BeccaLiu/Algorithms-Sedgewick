package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 9/30/16.
 * You may use only additions and subtractions and a constant amount of extra memory.
 * so the key is how to generate the mid, as we can not use divide anymore.
 */
public class E22_BinarySearchAddSub {
    public static void main(String[] args) {
        int size = 100;
        int[] a = new int[size];
        int inc = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = inc;
            inc = inc + 2;
        }
        int search = StdRandom.uniform(size);
        StdOut.println("result will be " + search);
        StdOut.println("find the index " + binarySearch(a, a[search]));
        StdOut.println("find the index " + binarySearch(a, a[search] - 1));
    }

    public static int binarySearch(int[] a, int num) {
        if (num > a[a.length - 1] || num < a[0])
            return -1;

//        ArrayList<Integer> fib = new ArrayList<>();
//        fib.add(0);
//        fib.add(1);
//        for (int i = 1; fib.get(i) + fib.get(i - 1) < a.length; i++) {
//            fib.add(fib.get(i) + fib.get(i - 1));
//        }
//        StdOut.println(fib);

        int FibK_1 = 0;
        int FibK = 1;
        while (FibK + FibK_1 < a.length) {
            int temp = FibK + FibK_1;
            FibK_1 = FibK;
            FibK = temp;
        }

        int low = 0;
        int high = a.length - 1;
        // int k = fib.size()-1 ;
        while (FibK >= 0) {
            int fIndex = low + FibK;
            if (fIndex > high || fIndex < low) {
                //k--;
                int FibK_2 = FibK - FibK_1;
                FibK = FibK_1;
                FibK_1 = FibK_2;
                continue;
            }
            if (a[fIndex] == num) {
                return fIndex;
            } else if (a[fIndex] > num) {
                high = fIndex - 1;
                //k--;
                int FibK_2 = FibK - FibK_1;
                FibK = FibK_1;
                FibK_1 = FibK_2;
            } else {
                low = fIndex + 1;
                //k-=2;
                int FibK_2 = FibK - FibK_1;
                int FibK_3 = FibK_1 - FibK_2;
                FibK = FibK_2;
                FibK_1 = FibK_3;
            }
        }
        return -1;
    }
}
