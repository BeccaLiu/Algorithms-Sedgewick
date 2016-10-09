package P5_UnionFind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashMap;

/**
 * Created by rliu on 10/8/16.
 */
public class E20_DynamicWUF {
    Node[] a;
    int component;
    int N;
    HashMap<Integer, Integer> map; //using hashcode to replace the hashmap?

    public E20_DynamicWUF() {
        component = 0;
        a = new Node[2];
        N = 0;
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        int[] x = new In("TestData/tinyUF.txt").readAllInts();
        int size = x[0];
        Stopwatch s = new Stopwatch();
        E20_DynamicWUF uf = new E20_DynamicWUF();
        for (int i = 1; i < x.length; i += 2) {
            uf.union(x[i], x[i + 1]);
            //StdOut.println(x[i] + " " + x[i + 1]);
        }

        StdOut.println(uf.N);
        for (int i = 0; i < size; i++) {
            if (uf.map.containsKey(i))
                StdOut.println(i + " " + uf.a[uf.find(i)].val);
            else
                StdOut.println(i + " ");
        }

        //the component will be different from the result of WeightedQuickUnion.java is because WeightedQuickUnion include the some site that never connect with others
        StdOut.println(uf.component);
        StdOut.println(uf.connected(5, 1));
        StdOut.println("function takes " + s.elapsedTime());

    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == -1)
            rootP = newSite(p);
        if (rootQ == -1)
            rootQ = newSite(q);

        if (rootP != rootQ) {
            if (a[rootP].size > a[rootQ].size) {
                a[rootQ].parent = a[rootP];
                a[rootQ].size += a[rootQ].size;
            } else {
                a[rootP].parent = a[rootQ];
                a[rootQ].size += a[rootP].size;
            }
            component--;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        if (map.containsKey(p)) {
            int i = map.get(p);
            while (a[i].parent != null)
                i = a[i].parent.id;
            return i;
        }
        return -1;
    }

    public int newSite(int val) {
        if (N == a.length)
            resize(2 * N);
        Node temp = new Node();
        temp.id = N;
        temp.parent = null;
        temp.val = val;
        temp.size = 1;
        component++;
        map.put(val, N);
        a[N++] = temp;
        return N - 1;
    }

    public void resize(int length) {
        Node[] temp = new Node[length];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        this.a = temp;
    }

    public int count() {
        return component;
    }

    private class Node {
        Node parent;
        int val;
        int id;
        int size;
    }
}
