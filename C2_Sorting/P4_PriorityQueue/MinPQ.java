package P4_PriorityQueue;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

/**
 * Created by rliu on 10/23/16.
 */
public class MinPQ<Key extends Comparable<Key>> implements Iterable<Key> {
    int N;
    Key[] pq;

    public MinPQ() {
        N = 0;
        pq = (Key[]) new Comparable[2];

    }

    public MinPQ(Key[] in) {
        N = in.length;
        pq = (Key[]) new Comparable[in.length + 1];
        for (int i = 0; i < in.length; i++)
            pq[i + 1] = in[i];
        for (int k = N / 2; k >= 1; k--) {
            sink(k);
        }

    }

    public static void main(String[] args) {
        int size = 50;
        MinPQ<Integer> pq = new MinPQ<Integer>();
        IntStream.range(0, size).forEach(i -> {
            pq.insert(StdRandom.uniform(100));
            if (i % 5 == 0) {
                StdOut.println(pq + " remove minimum" + pq.delMin() + " ");
            }
        });

        StdOut.println("(" + pq.size() + " left on pq)");
        StdOut.println(pq.toString());

        MinPQ<String> pq2 = new MinPQ<>();
        pq2.insert("this");
        pq2.insert("is");
        pq2.insert("a");
        pq2.insert("test");
        StdOut.println("(" + pq2.size() + " left on pq)");
        StdOut.println(pq2.toString());
        while (!pq2.isEmpty())
            StdOut.print(pq2.delMin() + " ");

    }

    public void insert(Key k) {
        if (N + 1 == pq.length)
            pq = (Key[]) Arrays.resize(pq, pq.length * 2);
        pq[++N] = k;
        swim(N);
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException();
        return pq[1];
    }

    public Key delMin() {
        if (isEmpty()) throw new NoSuchElementException();
        Key rt = pq[1];
        Arrays.exch(pq, 1, N--);
        sink(1);

        return rt;
    }

    public void swim(int k) {
        while (k / 2 >= 1 && Arrays.less(pq[k], pq[k / 2])) {
            Arrays.exch(pq, k, k / 2);
            k = k / 2;
        }
    }

    public void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && Arrays.less(pq[j + 1], pq[j])) j++;
            Arrays.exch(pq, j, k);
            k = j;
        }
    }

    public Iterator<Key> iterator() {
        return new heapIterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(pq[i] + " ");
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private class heapIterator implements Iterator<Key> {
        MinPQ<Key> copy;

        public heapIterator() {
            copy = new MinPQ<>();
            for (int i = 1; i <= N; i++) {
                copy.insert(pq[i]);
            }
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public Key next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return copy.delMin();
        }

    }
}
