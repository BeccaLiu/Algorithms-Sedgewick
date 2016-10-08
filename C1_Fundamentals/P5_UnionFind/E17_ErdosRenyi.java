package P5_UnionFind;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.UF;

/**
 * Created by rliu on 10/8/16.
 * <p>
 * https://en.wikipedia.org/wiki/Erd%C5%91s%E2%80%93R%C3%A9nyi_model
 */
public class E17_ErdosRenyi {
    public static int count(int N) {
        UF uf = new UF(N);
        int c = 0;
        while (true) {
            int p = StdRandom.uniform(0, N);
            int q = StdRandom.uniform(0, N);
            c++;
            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }
            if (fullyConnected(N, uf))
                return c;
        }
    }

    public static boolean fullyConnected(int N, UF uf) {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (!uf.connected(i, j))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize(400, 400);
        StdDraw.setXscale(0, 3000);
        StdDraw.setYscale(0, 20000);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BLUE);
        for (int i = 1; i < 3000; i *= 2) {
            StdDraw.point(i, count(i));
        }
    }

}
