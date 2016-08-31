import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ex_1_1_35 {
    public static void main(String[] args) {
        int sides = 6;
        double[] p = diceP(sides);
        StdOut.println("need test " + diceSimulation(p, sides) + " times");
        //some cases only need test 6290898 times; 46296004 17914675 15584685
        //at least 10^8
    }

    private static int diceSimulation(double[] p, int sides) {
        int i = 0;
        long[] p2 = new long[p.length];
        boolean[] isMatch = new boolean[p.length];
        while (true) {
            int a = StdRandom.uniform(1, sides + 1);
            int b = StdRandom.uniform(1, sides + 1);
            int sum = a + b;
            i++;
            p2[sum]++;

            isMatch[sum] = Math.abs((double) p2[sum] / i - p[sum]) <= 0.0001;
            boolean matched = true;
            for (int j = 2; j < isMatch.length; j++) {
                matched = matched && isMatch[j];
                if (matched == false)
                    break;
            }
            if (matched == true)
                break;
        }
        return i;

    }

    private static double[] diceP(int SIDES) {
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;
        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;
        return dist;
    }
}