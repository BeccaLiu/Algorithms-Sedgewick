package P5_UnionFind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 10/5/16.
 */
public class E12_QuickUnionPathCompress extends E7_QuickUnion {
    public E12_QuickUnionPathCompress(int N) {
        super(N);
    }

    public static void main(String[] args) {
        int[] x = new In("TestData/largeUF.txt").readAllInts();
        int size = x[0];
        E12_QuickUnionPathCompress uf = new E12_QuickUnionPathCompress(size);
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
        if (rootP != rootQ) {
            while (parent[p] != p) {
                int temp = parent[p];
                parent[p] = rootQ;
                p = temp;
            }
            parent[p] = rootQ;
            count--;
        }

    }
}
