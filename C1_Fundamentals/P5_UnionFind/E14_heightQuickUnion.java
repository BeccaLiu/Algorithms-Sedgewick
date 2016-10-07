package P5_UnionFind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/6/16.
 */
public class E14_heightQuickUnion {
    int[] parent;
    int[] height;
    int count;

    public E14_heightQuickUnion(int N) {
        count = N;
        parent = new int[N];
        height = new int[N];
        IntStream.range(0, N).forEach(i -> {
            parent[i] = i;
            height[i] = 0;
        });
    }

    public static void main(String[] args) {
        int[] x = new In("TestData/largeUF.txt").readAllInts();
        int size = x[0];
        Stopwatch s = new Stopwatch();
        E14_heightQuickUnion uf = new E14_heightQuickUnion(size);
        for (int i = 1; i < x.length; i += 2) {
            uf.union(x[i], x[i + 1]);
        }

        //uf.union(11,1);
        StdOut.println(uf.count);
        StdOut.println(uf.connected(5, 1));
        StdOut.println("function takes " + s.elapsedTime());
    }

    public void validate(int p) {
        int size = parent.length;
        if (p < 0 || p > size)
            throw new IndexOutOfBoundsException("input should within range");
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            int heightP = height[rootP];
            int heightQ = height[rootQ];
            if (heightP > heightQ) {
                parent[rootQ] = rootP;
                height[rootP] = heightP > heightQ + 1 ? heightP : heightQ + 1;
            } else {
                parent[rootP] = rootQ;
                height[rootQ] = heightP + 1 > heightQ ? heightP + 1 : heightQ;
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
}
