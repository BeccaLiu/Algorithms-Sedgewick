package C2_DataAbstraction;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by rliu on 8/26/16.
 */
public class ex_1_2_3 {
    public static void main(String[] args) {
        int scale = 400;
        StdDraw.setCanvasSize(scale + 2, scale + 2);
        StdDraw.setXscale(-1, scale + 1);
        StdDraw.setYscale(-1, scale + 1);

        int N = 10;
        int min = 0;
        int max = scale;

        Interval2D[] interval2Ds = new Interval2D[N];
        Interval1D[][] intervals = new Interval1D[N][2];

        construct2D(N, min, max, intervals);

        int intersect = 0;
        for (int i = 0; i < N; i++) {
            interval2Ds[i] = new Interval2D(intervals[i][0], intervals[i][1]);
            interval2Ds[i].draw();
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (interval2Ds[i].intersects(interval2Ds[j]))
                    intersect++;
            }
        }

        int contain = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i][0].min() < intervals[j][0].min() && intervals[i][0].max() > intervals[j][0].max() && intervals[i][1].min() < intervals[j][1].min() && intervals[i][1].max() > intervals[j][1].max())
                    contain++;
            }
        }
        StdOut.println("there are " + intersect + " pairs of intervals that intersect");
        StdOut.println("there are " + contain + " of intervals that are contained in one another");

    }

    public static void construct2D(int N, int min, int max, Interval1D[][] intervals) {
        for (int i = 0; i < N; i++) {
            double minX = StdRandom.uniform(min, max);
            double maxX = StdRandom.uniform(minX, max);
            double minY = StdRandom.uniform(min, max);
            double maxY = StdRandom.uniform(minY, max);

            intervals[i][0] = new Interval1D(minX, maxX);
            intervals[i][1] = new Interval1D(minY, maxY);
        }

        Arrays.sort(intervals, new Comparator<Interval1D[]>() {
            @Override
            public int compare(Interval1D[] o1, Interval1D[] o2) {
                if (o1[0].min() - o2[0].min() == 0) {
                    return (int) (o1[1].min() - o2[1].min());
                } else
                    return (int) (o1[0].min() - o2[0].min());
            }
        });
    }
}
