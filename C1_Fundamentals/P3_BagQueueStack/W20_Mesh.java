package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by rliu on 9/10/16.
 */
public class W20_Mesh implements Iterable<Double> {
    double left;
    double right;
    double delta;

    public W20_Mesh(double x, double y, double delta) {
        left = x;
        right = y;
        this.delta = delta;
    }

    public static void main(String[] args) {
        double left = 2.7654;
        double right = 0.1234;
        double delta = -0.02;

        int i = 0;
        for (double x : new W20_Mesh(left, right, delta)) {
            StdOut.println(x);
            i++;
        }

        StdOut.println(i);
        StdOut.println(1 + Math.floor((right - left) / delta));

    }

    public Iterator<Double> iterator() {
        return new Iterator<Double>() {
            int times = 1 + (int) Math.floor((right - left) / delta);
            int i = 0;
            double start = left;

            @Override
            public boolean hasNext() {
                return i < times;
            }

            @Override
            public Double next() {
                i++;
                double temp = start;
                start = start + delta;
                return temp;
            }
        };
    }

}
