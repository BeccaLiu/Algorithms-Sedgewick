package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 10/2/16.
 */
public class E24_ThrowEgg {

    public static void main(String[] args) {
        int N = 100;//only know the height of the building.
        int F = 64;//StdRandom.uniform(N); //the F will generated randomly,
        boolean[] exp = new boolean[100];
        for (int i = 0; i < N; i++) {
            if (i >= F)
                exp[i] = true;
        }
        StdOut.println("O(N)" + findF(exp)); //know the F in O(N)time
        StdOut.println("O(lgN)" + findFFaster(exp, 1, exp.length));
        StdOut.println("O(2lgF)" + findFFastest(exp));
    }

    public static int findF(boolean[] exp) { //O(N)

        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == false) //throw the egg from floor 1 to floor N, when the egg is broken at floor F, print floor F.
                continue;
            return i;
        }
        return -1;
    }

    public static int findFFaster(boolean[] exp, int low, int high) { //O(logN)
        if (low > high)
            return -1;
        int mid = low + (high - low) / 2;
        if (exp[mid] == true && exp[mid - 1] == false)
            return mid;
        else if (exp[mid] == false) { //at floor mid, the egg is  broken
            return findFFaster(exp, mid + 1, high);
        } else
            return findFFaster(exp, low, mid - 1);

    }

    public static int findFFastest(boolean[] exp) { //2logF
        int low = 1;
        while (low <= exp.length && exp[low] == false) {
            low *= 2;
        }
        if (low < exp.length && exp[low] == true && exp[low - 1] == false)
            return low;
        int high = low;
        if (high > exp.length)
            high = exp.length;
        low /= 2;
        return findFFaster(exp, low, high);

    }
}
