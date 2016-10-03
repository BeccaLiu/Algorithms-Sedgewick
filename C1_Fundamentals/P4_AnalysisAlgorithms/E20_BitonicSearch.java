package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 9/29/16.
 */
public class E20_BitonicSearch {
    public static void main(String[] args) {
        int size = 50;
        int[] a = generateRandomBitonicArray(size);
        int searchIndex = StdRandom.uniform(size);
        int num = a[searchIndex];
        int index = findMax(a);
        StdOut.println("Auto generated search " + searchIndex);
        int findIndex = searchInInc(a, index, num);
        if (findIndex != -1)
            StdOut.println("find at " + findIndex);
        else {
            StdOut.println(searchInDes(a, index, num));
        }
    }

    public static int[] generateRandomBitonicArray(int size) {
        int[] a = new int[size];
        int val = 1;
        int maxIndex = StdRandom.uniform(size);
        StdOut.println("random max index " + maxIndex);
        for (int i = 0; i < a.length; i++) {
            if (i <= maxIndex) {
                a[i] = (val * 2);
                val++;
            } else {
                val--;
                a[i] = val * 2 - 1;
            }
        }
        return a;
    }

    public static int findMax(int[] a) { //logn
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1])
                return mid;
            else if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static int searchInInc(int[] a, int maxIndex, int num) {
        int low = 0;
        int high = maxIndex;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == num)
                return mid;
            else if (a[mid] > num)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static int searchInDes(int[] a, int maxIndex, int num) {
        int low = maxIndex;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == num)
                return mid;
            else if (a[mid] > num)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
