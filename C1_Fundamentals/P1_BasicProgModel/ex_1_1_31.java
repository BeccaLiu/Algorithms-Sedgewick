import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ex_1_1_31 {
    public static void main(String[] args) {
        StdOut.print("Input N for how many dots you want to draw: ");
        int N = StdIn.readInt();
        StdOut.print("Input probability p that a line will be draw between each pair of points ([0,1]): ");
        double P = StdIn.readDouble();
        if (P < 0 || P > 1)
            throw new IllegalArgumentException(" probability should be between 0 and 1");
        randomConnection(N, P);
    }

    public static void randomConnection(int N, double P) {
        double[][] dots = new double[N][2];
        int xScale = 60;
        int yScale = 60;
        int diameter = 50;
        StdDraw.setXscale(0, xScale * 2);
        StdDraw.setYscale(0, yScale * 2);

        drawCircle(xScale, yScale, diameter, dots);
        drawLine(P, dots);
    }

    public static void drawCircle(int xScale, int yScale, int diameter, double[][] dots) {
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.circle(xScale, yScale, diameter);
        int N = dots.length;
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < dots.length; i++) {
            dots[i][0] = xScale + diameter * Math.sin(2 * Math.PI * i / N);
            dots[i][1] = yScale + diameter * Math.cos(2 * Math.PI * i / N);
            StdDraw.point(dots[i][0], dots[i][1]);
        }
    }

    public static void drawLine(double p, double[][] dots) {
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        int N = dots.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (StdRandom.bernoulli(p))
                    StdDraw.line(dots[i][0], dots[i][1], dots[j][0], dots[j][1]);
            }

        }


    }
}
