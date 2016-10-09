package P5_UnionFind;

import P3_BagQueueStack.RandomBag;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

/**
 * Created by rliu on 10/8/16.
 * //generate a grid in picture without using union find
 */
public class E18_RandomGrid {
    public static void main(String[] args) {
        int N = 50;
        RandomBag<Connection> a = generated(N);
        UF uf = new UF((N + 1) * (N + 1));//E 1.5.19
        StdDraw.setCanvasSize(400, 400);
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.BLUE);
        for (Connection c : a) {
            uf.union(c.p, c.q);
            StdDraw.line(c.p / (N + 1), c.p % (N + 1), c.q / (N + 1), c.q % (N + 1));
            StdOut.println(uf.count()); //will only print 1 if the grid is fully connected
        }
    }

    public static RandomBag<Connection> generated(int N) {
        RandomBag<Connection> randomBag = new RandomBag<>();
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (j != N)
                    randomBag.add(new Connection(i * (N + 1) + j, i * (N + 1) + j + 1));
                if (i != N)
                    randomBag.add(new Connection(i * (N + 1) + j, (i + 1) * (N + 1) + j));
            }
        }
        return randomBag;
    }

    private static class Connection {
        int p;
        int q;

        public Connection(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }
}
