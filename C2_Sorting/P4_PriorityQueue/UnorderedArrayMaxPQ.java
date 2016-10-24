package P4_PriorityQueue;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

/**
 * Created by rliu on 10/23/16.
 */
public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> {
    private int N;
    private Key[] a;

    public UnorderedArrayMaxPQ() {
        a = (Key[]) new Comparable[2];
        N = 0;
    }

    public UnorderedArrayMaxPQ(Key[] in) {
        N = 0;
        a = (Key[]) new Comparable[in.length];
        for (int i = 0; i < in.length; i++) {
            a[i] = in[i];
            N++;
        }
    }

    public static void main(String[] args) {
        int size = 50;
        Integer[] arr = new Integer[size];
        IntStream.range(0, size).forEach(i -> arr[i] = StdRandom.uniform(100));

        UnorderedArrayMaxPQ<Integer> pq = new UnorderedArrayMaxPQ(arr);

        pq.insert(50);
        StdOut.println(pq.max());
        pq.insert(101);
        while (!pq.isEmpty()) {
            StdOut.print(pq.delMax() + " ");
        }

        StdOut.println();
        UnorderedArrayMaxPQ<String> pq2 = new UnorderedArrayMaxPQ<>();
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
        a[N++] = k;
    }

    public Key max() {
        if (isEmpty())
            throw new NoSuchElementException();
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (Arrays.less(a[max], a[i]))
                max = i;
        }
        Arrays.exch(a, max, N - 1);
        return a[N - 1];
    }

    public Key delMax() {
        if (isEmpty())
            throw new NoSuchElementException();
        Key rt = max();
        N--;
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
