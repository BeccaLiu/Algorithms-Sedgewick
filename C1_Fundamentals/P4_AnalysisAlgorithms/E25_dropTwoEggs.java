package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 10/2/16.
 */
public class E25_dropTwoEggs {
    public static void main(String[] args) {
        int N = 100;//only know the height of the building.
        int F = 99;
        StdRandom.uniform(N); //the F will generated randomly,
        boolean[] intakeEgg = new boolean[100];
        for (int i = 0; i < N; i++) {
            if (i < F)
                intakeEgg[i] = true;
        }
        StdOut.println("O(2VN)" + findF(intakeEgg)); //find the F in O(2*sqrt(N))time
        StdOut.println("O(cVK)" + findFFaster(intakeEgg));

    }

    public static int findF(boolean[] intactEggs) {
        int interval = (int) Math.floor(Math.sqrt(intactEggs.length));
        int curr = interval;
        while (curr < intactEggs.length)  //sqrt(N) times
            if (intactEggs[curr - 1] == true)
                curr += interval;
            else
                break;
        curr = curr - interval + 1;
        for (int i = curr; i < intactEggs.length; i++) { //Sqrt(N) times
            if (intactEggs[i] == false)
                return i;
        }
        return -1;
    }

    public static int findFFaster(boolean[] intactEggs) {
        //every time jump n floors, and if egg is not broken, then go up n-1 floor, so it will be n+(n-1)+(n-2)+...1>=N, (1+n)*n/2>=N;
        int interval = (int) Math.floor(Math.sqrt(2 * intactEggs.length));
        int curr = interval;
        while (curr < intactEggs.length)  //interval times
            if (intactEggs[curr - 1] == true)
                curr += --interval;
            else
                break;
        curr = curr - interval;
        for (int i = curr; i < intactEggs.length; i++) { //Sqrt(N) times
            if (intactEggs[i] == false)
                return i;
        }
        return -1;
    }
}
