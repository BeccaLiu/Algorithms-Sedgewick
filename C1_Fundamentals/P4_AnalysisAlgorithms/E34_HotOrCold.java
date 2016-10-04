package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 10/3/16.
 */
public class E34_HotOrCold {
    public static void main(String[] args) {
        int N = 100;
        int goal = StdRandom.uniform(0, 100) + 1;
        StdOut.println(findG(goal, N));
        StdOut.println(findGFaster(goal, N));
    }

    public static int findG(int goal, int N) {  //2logN method,
        int low = 1;
        int high = N;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int dif1 = Math.abs(goal - mid);
            if (dif1 == 0)
                return mid;
            int dif2 = Math.abs(goal - mid - 1);//every iteration, call abs twice means ask 2 times, so total will be 2Log N
            if (dif2 == 0)
                return mid + 1;
            else if (dif2 > dif1)
                high = mid - 1;
            else if (dif2 < dif1)
                low = mid + 2;
        }
        return -1;
    }

    public static int findGFaster(int goal, int N) {
        int low = 1;
        int high = N;

        int difLow = Math.abs(low - goal);
        int difHigh = Math.abs(high - goal);
        while (low <= high) { //// every iteration,only ask once, either the low or high;
            if (difLow == 0)
                return low;
            if (difHigh == 0)
                return high;
            int mid = low + (high - low) / 2;
            if (difLow == difHigh)
                return mid;
            else if (difLow < difHigh) {
                high = mid - 1;
                difHigh = Math.abs(high - goal);
            } else {
                low = mid + 1;
                difLow = Math.abs(low - goal);
            }
        }
        return -1;
    }


}
