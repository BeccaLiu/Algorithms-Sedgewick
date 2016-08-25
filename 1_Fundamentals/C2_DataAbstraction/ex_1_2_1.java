package C2_DataAbstraction;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

/**
 * Created by rliu on 8/24/16. Using Divide and Conquer and the time complexity is O(nlogn)
 */
public class ex_1_2_1 {
    public static Point2D p1, p2;
    public static double bestDis = Double.POSITIVE_INFINITY;

    public static void main(String[] args) {
        StdOut.print("input N: ");
        int n = StdIn.readInt();
        int scale = 400;
        StdDraw.setCanvasSize(scale, scale);
        StdDraw.setXscale(0, scale);
        StdDraw.setYscale(0, scale);
        StdDraw.setPenRadius(0.005);
        StdDraw.enableDoubleBuffering();

        Point2D[] pointsX = new Point2D[n];
        Point2D[] pointsY = new Point2D[n];

        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniform(scale);
            double y = StdRandom.uniform(scale);
            pointsX[i] = new Point2D(x, y);
            pointsY[i] = pointsX[i];
            pointsX[i].draw();
            StdDraw.show();
        }

        //TODO: check if there is any coincident, then the distance will be 0

        Arrays.sort(pointsX, Point2D.X_ORDER);
        Point2D[] aux = new Point2D[n];

        closetPair(pointsX, pointsX, aux, 0, n - 1);
        StdDraw.line(p1.x(), p1.y(), p2.x(), p2.y());
        StdDraw.text(Math.min(p1.x(), p2.x()), Math.min(p1.y(), p2.y()), bestDis + "");
        StdDraw.show();
        StdOut.println(bestDis + " from " + p1 + " to " + p2);

    }


    public static double closetPair(Point2D[] pointsX, Point2D[] pointsY, Point2D[] aux, int lo, int hi) {
        if (lo >= hi)
            return Double.POSITIVE_INFINITY;
        int mid = lo + (hi - lo) / 2;
        double median = pointsX[mid].x(); //using x coordinate of PointsX[mid] as the separate line
        double deltaL = closetPair(pointsX, pointsX, aux, lo, mid);
        double deltaR = closetPair(pointsX, pointsX, aux, mid + 1, hi);
        double delta = Math.min(deltaL, deltaR);
        merge(pointsY, aux, lo, mid, hi);
        minMid(pointsY, aux, median, lo, mid, hi);

        StdOut.println(bestDis + " from " + p1 + " to " + p2);
        return bestDis;
    }

    public static double minMid(Point2D[] point2Ds, Point2D[] aux, double median, int lo, int mid, int hi) {
        int m = 0;
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(point2Ds[i].x() - median) < bestDis)
                aux[m++] = point2Ds[i];
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m && (Math.abs(aux[i].y() - aux[j].y()) < bestDis); j++) { //Math.abs(aux[i].y()-aux[j].y())<bestDis is important
                double dis = aux[i].distanceTo(aux[j]);
                if (dis < bestDis) {
                    bestDis = dis;
                    p1 = aux[i];
                    p2 = aux[j];
                }

            }
        }
        return bestDis;


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

}
