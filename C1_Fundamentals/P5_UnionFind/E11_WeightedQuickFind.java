package P5_UnionFind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/5/16.
 */
public class E11_WeightedQuickFind {


    int count;
    int[] a;
    int[] size;

    public E11_WeightedQuickFind(int N) {
        count = N;
        a = new int[N];
        size = new int[N];
        IntStream.range(0, N).parallel().forEach(i -> a[i] = i);
        IntStream.range(0, N).parallel().forEach(i -> size[i] = 1);
    }

    public static void main(String[] args) {
        int[] x = new In("TestData/mediumUF.txt").readAllInts();
        int size = x[0];
        E11_WeightedQuickFind uf = new E11_WeightedQuickFind(size);
        Stopwatch s = new Stopwatch();
        for (int i = 1; i < x.length; i += 2) {
            uf.union(x[i], x[i + 1]);
        }
        StdOut.println(s.elapsedTime());
        //uf.union(11,1);
        StdOut.println(uf.count);
        StdOut.println(uf.connected(5, 1));
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);
        int idP = a[p];
        int idQ = a[q];
        int sizeP = size[p]; //it is useless to change the id[] entries of the smaller component to the identifier of the larger component. using size does not eliminate cases
        int sizeQ = size[q];
        if (a[p] != a[q]) {
            int rootIndex;
            int appendix;
            if (sizeP <= sizeQ) {
                rootIndex = idQ;
                appendix = idP;
            } else {
                rootIndex = idP;
                appendix = idQ;
            }
            for (int i = 0; i < a.length; i++) {
                if (a[i] == appendix) {
                    a[i] = rootIndex;
                    size[i] = sizeP + sizeQ;
                }
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
