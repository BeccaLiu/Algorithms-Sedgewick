package P3_BagQueueStack;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 9/18/16.
 */
public class W45_Grid {
    public static void main(String[] args) {
        int n = 20;
        double d = 0.09;

        int rows = (int) (Math.ceil(1.0 / d));    // # rows in grid ,if d=0.9, 1.0/0.9=11.1.... ceil(11.1111)=12
        int cols = (int) (Math.ceil(1.0 / d));    // # columns in grid

        Queue<Point2D>[][] grid = new Queue[rows + 2][cols + 2]; //2 more for left empty and right empty
        for (int i = 0; i <= rows + 1; i++)
            for (int j = 0; j <= cols + 1; j++)
                grid[i][j] = new Queue<Point2D>();
        for (int k = 0; k < n; k++) {
            double x = StdRandom.uniform(0.0, 1.0);
            double y = StdRandom.uniform(0.0, 1.0);
            Point2D p = new Point2D(x, y);
            int row = 1 + (int) (x * rows);
            int col = 1 + (int) (y * rows);
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j < col + 1; j++) {
                    for (Point2D q : grid[i][j])
                        if (p.distanceTo(q) <= d)
                            StdOut.println(p + " <--> " + q);
                }
            }
            grid[row][col].enqueue(p);

        }
    }
}
