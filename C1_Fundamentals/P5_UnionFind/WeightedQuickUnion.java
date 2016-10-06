package P5_UnionFind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/5/16.
 */
public class WeightedQuickUnion {

    int count;
    int[] parent;
    int[] size;

    public WeightedQuickUnion(int N) {
        count = N;
        parent = new int[N];
        size = new int[N];
        IntStream.range(0, N).parallel().forEach(i -> {
            parent[i] = i;
            size[i] = 1;
        });
    }

    public static void main(String[] args) {
        int[] x = new In("TestData/largeUF.txt").readAllInts();
        int size = x[0];
        Stopwatch s = new Stopwatch();
        WeightedQuickUnion uf = new WeightedQuickUnion(size);
        for (int i = 1; i < x.length; i += 2) {
            uf.union(x[i], x[i + 1]);
        }

        //uf.union(11,1);
        StdOut.println(uf.count);
        StdOut.println(uf.connected(5, 1));
        StdOut.println("function takes " + s.elapsedTime());
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            int sizeP = size[rootP];
            int sizeQ = size[rootQ];
            if (sizeP > sizeQ) {
                parent[rootQ] = rootP; //1.5.10 even change parent[rootQ] = parent[rootP] will not affect the result, as the rootP is the root, and the parent is itself
                size[rootP] = sizeP + sizeQ;
            } else {
                parent[rootP] = rootQ;
                size[rootQ] = sizeP + sizeQ;
            }
            count--;
        }
    }

    public int find(int p) {
        validate(p);

        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void validate(int p) {
        int size = parent.length;
        if (p < 0 || p > size)
            throw new IndexOutOfBoundsException();
    }

    public int count() {//number of component
        return count;
    }

}
