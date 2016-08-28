package C2_DataAbstraction;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 8/27/16.
 */
public class VisualCounter {
    private final int operationMax;
    private final int countMax;
    private int count = 0;
    private int operation = 0;

    public VisualCounter(int N, int max) {
        operationMax = N;
        countMax = max;
        StdDraw.setCanvasSize(operationMax, countMax * 5);
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(-max, max);
        StdDraw.setPenRadius(0.005);
    }

    public static void main(String[] args) throws Exception {
        VisualCounter vc = new VisualCounter(800, 40);
        while (true) {
            if (StdRandom.bernoulli()) {
                vc.increment();
                StdOut.println(vc.tally());
            } else {
                vc.decrement();
                StdOut.println(vc.tally());
            }
        }

    }

    public void increment() throws Exception {
        if (count > countMax)
            throw new Exception("exceed the counter maximum value");
        if (operation > operationMax)
            throw new Exception("exceed the operation maximum value");
        count++;
        operation++;
        plot(count, operation);
    }

    public void decrement() throws Exception {
        if (count < -countMax)
            throw new Exception("exceed the counter minimum value");
        if (operation > operationMax)
            throw new Exception("exceed the operation maximum value");
        count--;
        operation++;
        plot(count, operation);
    }

    public int tally() {
        return count;
    }

    @Override
    public String toString() {
        return (count + " with operation " + operation);
    }

    private void plot(int count, int operation) {
        StdDraw.point(operation, count);
    }
}
