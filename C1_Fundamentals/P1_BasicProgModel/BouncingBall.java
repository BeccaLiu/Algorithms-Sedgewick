import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class BouncingBall {
    public static void main(String[] args) {
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // initial values
        double rx = StdRandom.uniform(-10, 10) * 0.09, ry = StdRandom.uniform(-10, 10) * 0.09;     // position
        double vx = 0.015, vy = 0.023;     // velocity
        double radius = 0.05;
        StdOut.print(rx + "/" + ry);

        while (true) {
            if (Math.abs(rx + vx) > 1.0 - radius) vx = -vx;
            if (Math.abs(ry + vy) > 1.0 - radius) vy = -vy;

            rx = rx + vx;
            ry = ry + vy;
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(0, 0, 1.0);

            StdDraw.setPenColor(Color.GREEN);
            StdDraw.filledCircle(rx, ry, radius);

            StdDraw.show();
            StdDraw.pause(20);

        }
    }
}