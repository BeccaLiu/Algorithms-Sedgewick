package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by rliu on 9/22/16.
 */
public class E10_MBinarySearch {
    public static void main(String[] args) {
        StdOut.println("Input the number you want to search:");
        int target = StdIn.readInt();
        String[] s = new In("TestData/tinyT.txt").readAllLines();
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        int index = binarySearch(arr, target);
        if (index == -1)
            StdOut.println("No Found");
        else
            StdOut.println(index);


    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int index = -1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target)
                high = mid - 1;
            else if (arr[mid] < target)
                low = mid + 1;
            else {
                while (arr[mid - 1] == target)
                    mid--;
                index = mid;
                break;
            }
        }
        return index;
    }
}
