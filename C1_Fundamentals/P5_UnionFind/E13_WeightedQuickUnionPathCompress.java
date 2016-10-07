package P5_UnionFind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 10/6/16.
 */
public class E13_WeightedQuickUnionPathCompress extends WeightedQuickUnion {
    public E13_WeightedQuickUnionPathCompress(int N) {
        super(N);
    }

    public static void main(String[] args) {
        int[] x = new In("TestData/largeUF.txt").readAllInts();
        int size = x[0];
        E13_WeightedQuickUnionPathCompress uf = new E13_WeightedQuickUnionPathCompress(size);
        for (int i = 1; i < x.length; i += 2) {
            uf.union(x[i], x[i + 1]);
        }
        //uf.union(11,1);
        StdOut.println(uf.count);
        StdOut.println(uf.connected(5, 1));
    }

    @Override
    public void union(int p, int q) {
        validate(p);
        validate(q);
        int rootP = find(p);
        int rootQ = find(q);
        if (find(p) != find(q)) {
            int sizeP = size[rootP];
            int sizeQ = size[rootQ];
            if (sizeP > sizeQ) {
                while (parent[q] != q) {
                    int temp = parent[q];
                    parent[q] = rootP;
                    q = temp;
                }
                parent[rootQ] = rootP;
                size[rootP] += sizeQ;
            } else {
                while (parent[p] != p) {
                    int temp = parent[p];
                    parent[p] = rootQ;
                    p = temp;
                }
                parent[rootP] = rootQ;
                size[rootQ] += sizeP;
            }
            count--;
        }
    }
}
