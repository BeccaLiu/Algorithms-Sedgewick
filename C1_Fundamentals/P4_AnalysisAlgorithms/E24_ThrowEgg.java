package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 10/2/16.
 */
public class E24_ThrowEgg {

    public static void main(String[] args) {
        int N = 100;//only know the height of the building.
        int F = StdRandom.uniform(N); //the F will generated randomly,
        boolean[] exp = new boolean[100];
        for (int i = 0; i < N; i++) {
            if (i < F)
                exp[i] = true; //when egg is not break at floor i;
        }
        StdOut.println("O(N)" + findF(exp)); //know the F in O(N)time
        StdOut.println("O(lgN)" + findFFaster(exp, 0, exp.length - 1));
        StdOut.println("O(2lgF)" + findFFastest(exp));
    }

    public static int findF(boolean[] exp) { //O(N)

        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == true) //throw the egg from floor 1 to floor N, when the egg is broken at floor F, print floor F.
                continue;
            return i;
        }
        return -1;
    }

    public static int findFFaster(boolean[] exp, int low, int high) { //O(logN)
        if (exp[low] == false) //the egg will break at first floor where exp[0]=false, to eliminate the error check exp[mid-1] out of boundary
            return low;
        if (low > high)
            return -1;
        int mid = low + (high - low) / 2;
        if (exp[mid] == false && exp[mid - 1] == true)
            return mid;
        else if (exp[mid] == true) { //at floor mid, the egg is  broken
            return findFFaster(exp, mid + 1, high);
        } else
            return findFFaster(exp, low, mid - 1);

    }

    public static int findFFastest(boolean[] exp) { //2logF
        int low = 1;
        while (low <= exp.length && exp[low] == true) {
            low *= 2;
        }
        if (low < exp.length && exp[low] == true && exp[low - 1] == true)
            return low;
        int high = low;
        if (high > exp.length)
            high = exp.length;
        low /= 2;
        return findFFaster(exp, low, high);

    }
}
