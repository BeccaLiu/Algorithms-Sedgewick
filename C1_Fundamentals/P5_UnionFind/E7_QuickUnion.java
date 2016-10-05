package P5_UnionFind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/5/16.
 */
public class E7_QuickUnion {
    int count;
    int[] parent;

    public E7_QuickUnion(int size) {
        count = size;
        parent = new int[size];
        IntStream.range(0, size).parallel().forEach(i -> parent[i] = i);
    }

    public static void main(String[] args) {
        int[] x = new In("TestData/mediumUF.txt").readAllInts();
        int size = x[0];
        E7_QuickUnion uf = new E7_QuickUnion(size);
        for (int i = 1; i < x.length; i += 2) {
            uf.union(x[i], x[i + 1]);
        }
        //uf.union(11,1);
        StdOut.println(uf.count);
        StdOut.println(uf.connected(5, 1));
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pIndex = find(p);
        int qIndex = find(q);
        if (pIndex != qIndex) {
            parent[pIndex] = qIndex;
            count--;
        }
    }

    public int find(int p) {
        validate(p);
        while (parent[p] != p)
            p = parent[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void validate(int p) {
        int size = parent.length;
        if (p < 0 || p > size)
            throw new IllegalStateException();
    }

    public int count() {//number of component
        return count;
    }
}
