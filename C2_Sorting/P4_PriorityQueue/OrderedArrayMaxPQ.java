package P4_PriorityQueue;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

/**
 * Created by rliu on 10/23/16.
 */
public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
    int N = 0;
    Key[] a;

    public OrderedArrayMaxPQ() {
        N = 0;
        a = (Key[]) new Comparable[2];
    }

    public OrderedArrayMaxPQ(Key[] arr) {
        N = 0;
        a = (Key[]) new Comparable[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
            N++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && Arrays.less(a[j], a[j - 1]); j--) {
                Arrays.exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        int size = 50;
        Integer[] arr = new Integer[size];
        IntStream.range(0, size).forEach(i -> arr[i] = StdRandom.uniform(100));

        OrderedArrayMaxPQ<Integer> pq = new OrderedArrayMaxPQ(arr);

        pq.insert(50);
        StdOut.println(pq.max());
        pq.insert(101);
        while (!pq.isEmpty()) {
            StdOut.print(pq.delMax() + " ");
        }

        StdOut.println();
        OrderedArrayMaxPQ<String> pq2 = new OrderedArrayMaxPQ<>();
        pq2.insert("this");
        pq2.insert("is");
        pq2.insert("pq");
        pq2.insert("test");
        while (!pq2.isEmpty()) {
            StdOut.print(pq2.delMax() + " ");
        }
    }

    public void insert(Key k) {
        if (N == a.length)
            a = (Key[]) Arrays.resize(a, N * 2);
        a[N] = k;
        int j = N;
        while (j > 0 && Arrays.less(a[j], a[j - 1])) {
            Arrays.exch(a, j, j - 1);
            j--;
        }
        N++;
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException();
        return a[N - 1];
    }

    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException();
        Key rt = a[--N];
        if (N > 0 && N == a.length / 4)
            a = (Key[]) Arrays.resize(a, a.length / 2);
        return rt;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
}
