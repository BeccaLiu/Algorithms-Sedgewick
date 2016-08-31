package P2_DataAbstraction;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

/**
 * Created by rliu on 8/24/16. Using Divide and Conquer and the time complexity is O(nlogn)
 * the idea of divide and conquer is a way to go through all the data,
 * need a bestDis to tracking the closet distance you find so far, but do not mix it with delta which is the return value of divideConquer function closetPair()
 */
public class ex_1_2_1 {
    public static Point2D p1, p2;
    public static double bestDis = Double.POSITIVE_INFINITY; //**set initial value as Double.POSITIVE_INFINITY

    public static void main(String[] args) {
        StdOut.print("input N: ");
        int n = StdIn.readInt();
        int scale = 400;
        StdDraw.setCanvasSize(scale, scale);
        StdDraw.setXscale(-1, scale + 1);
        StdDraw.setYscale(-1, scale + 1);
        StdDraw.setPenRadius(0.005);
        StdDraw.enableDoubleBuffering();

        Point2D[] pointsX = new Point2D[n];
        //Point2D[] pointsY = new Point2D[n];

        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniform(scale);
            double y = StdRandom.uniform(scale);
            pointsX[i] = new Point2D(x, y);
            //pointsY[i] = pointsX[i]; error: error: pointX will be sorted lately, if you give value to pointY here, then the pointX and pointY is not equivalent which cause error lately
            pointsX[i].draw();
            StdDraw.show();
        }

        //TODO: check if there is any coincident, then the distance will be 0

        Arrays.sort(pointsX, Point2D.X_ORDER);
        Point2D[] aux = new Point2D[n];
        bruceForce(pointsX, n);
        closetPair(pointsX, aux, 0, n - 1);
        StdDraw.line(p1.x(), p1.y(), p2.x(), p2.y());
        // StdDraw.text(Math.min(p1.x(), p2.x()), Math.min(p1.y(), p2.y()), bestDis + "");
        StdDraw.show();
        StdOut.println(bestDis + " from " + p1 + " to " + p2);

    }


    public static double closetPair(Point2D[] points, Point2D[] aux, int lo, int hi) {
        if (lo >= hi)
            return Double.POSITIVE_INFINITY;
        int mid = lo + (hi - lo) / 2;
        Point2D median = points[mid]; //using x coordinate of PointsX[mid] as the separate line
        double deltaL = closetPair(points, aux, lo, mid);
        double deltaR = closetPair(points, aux, mid + 1, hi);
        double delta = Math.min(deltaL, deltaR);
        merge(points, aux, lo, mid, hi);
        //minMid(pointsY, aux, median, lo, mid, hi);  //bestDis and delta are different things, do not confused them,
        delta = minMid(points, aux, median, delta, lo, hi);
        //return bestDis; *should not return bestDis
        return delta;
    }

    public static double minMid(Point2D[] pointsByY, Point2D[] aux, Point2D median, double delta, int lo, int hi) {
        int m = 0;
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(pointsByY[i].x() - median.x()) < delta)
                aux[m++] = pointsByY[i];
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; (j < m) && (aux[j].y() - aux[i].y() < delta); j++) { //Math.abs(aux[i].y()-aux[j].y())<delta is important, pay attention, do not use bestDis here
                double dis = aux[i].distanceTo(aux[j]);
                if (dis < delta) {
                    delta = dis;
                    if (dis < bestDis) {
                        bestDis = dis;
                        p1 = aux[i];
                        p2 = aux[j];
                    }
                }
            }
        }
        //return bestDis;
        return delta;
    }

    public static void merge(Point2D[] pointsY, Point2D[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = pointsY[i];
        }
        int l = lo;
        int r = mid + 1;
        for (int i = lo; i <= hi; i++) {
            if (l > mid)
                pointsY[i] = aux[r++];
            else if (r > hi)
                pointsY[i] = aux[l++];
            else if (aux[l].y() < aux[r].y())
                pointsY[i] = aux[l++];
            else
                pointsY[i] = aux[r++];
        }
    }

    public static void bruceForce(Point2D[] pointsX, int n) {
        double min = Double.POSITIVE_INFINITY;
        Point2D u = null, v = null;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dis = pointsX[i].distanceTo(pointsX[j]);
                if (dis < min) {
                    min = dis;
                    u = pointsX[i];
                    v = pointsX[j];
                }
            }
        }
        StdOut.println("\n" + min + " from " + u + " to " + v);

    }

}
