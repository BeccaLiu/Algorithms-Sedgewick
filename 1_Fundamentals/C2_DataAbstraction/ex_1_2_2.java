package C2_DataAbstraction;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by rliu on 8/26/16.
 */
public class ex_1_2_2 {
    public static void main(String[] args) {
        int N = StdRandom.uniform(100);
        Interval1D[] interval1Ds = new Interval1D[N];
        for (int i = 0; i < N; i++) {
            double min = StdRandom.uniform(N / 4);
            double max = StdRandom.uniform(min, N / 4);
            interval1Ds[i] = new Interval1D(min, max);
        }
        Arrays.sort(interval1Ds, new Comparator<Interval1D>() {
            @Override
            public int compare(Interval1D o1, Interval1D o2) {
                if (o1.min() - o2.min() == 0)
                    return (int) (o1.max() - o2.max());
                else return (int) (o1.min() - o2.min());
            }
        });
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N && (interval1Ds[j].min() < interval1Ds[i].max()); j++) {
                if (interval1Ds[i].intersects(interval1Ds[j]))
                    StdOut.println(interval1Ds[i] + " intersect with " + interval1Ds[j]);
            }
        }
    }
}
