package P5_UnionFind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/5/16.
 */
public class E7_QuickFind {

    int count;
    int[] a;

    public E7_QuickFind(int size) {
        count = size;
        a = new int[size];
        IntStream.range(0, size).parallel().forEach(i -> a[i] = i);
    }

    public static void main(String[] args) {
        int[] x = new In("TestData/mediumUF.txt").readAllInts();
        int size = x[0];
        E7_QuickFind uf = new E7_QuickFind(size);
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
        int idP = a[p];
        int idQ = a[q];
        if (a[p] != a[q]) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == idP)
                    a[i] = idQ;
            }
            count--;
        }
    }

    public int find(int p) {
        validate(p);
        return a[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void validate(int p) {
        int size = a.length;
        if (p < 0 || p > size)
            throw new IllegalStateException();
    }

    public int count() {//number of component
        return count;
    }
}
