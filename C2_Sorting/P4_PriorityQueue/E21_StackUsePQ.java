package P4_PriorityQueue;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

/**
 * Created by rliu on 10/29/16.
 * To implement Queue using Priority Queue just use minPQ to store the index of input
 */
public class E21_StackUsePQ<Item> implements Iterable<Item> {
    MaxPQ<Integer> pq;
    Item[] items;

    public E21_StackUsePQ() {
        pq = new MaxPQ<>();
        items = (Item[]) new Object[2];
    }

    public static void main(String[] args) {
        E21_StackUsePQ<Integer> spq = new E21_StackUsePQ<>();
        IntStream.range(0, 30).forEach(i -> {
            int temp = StdRandom.uniform(100);
            spq.push(temp);
            StdOut.print(temp + " ");
            if (i % 5 == 0) {
                StdOut.println(" pop:" + spq.pop());
            }

        });

        StdOut.println();
        StdOut.println(spq);
        while (!spq.isEmpty()) {
            StdOut.print(spq.pop() + " ");
        }

    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public int size() {
        return pq.size();
    }

    private void resize(int size) {
        Item[] newItems = (Item[]) new Object[size];
        for (int i = 0; i < pq.size(); i++) {
            newItems[i] = items[i];
        }
        this.items = newItems;
    }

    public void push(Item item) {
        if (pq.size() == items.length)
            resize(items.length * 2);
        int size = pq.size();
        items[size] = item;
        pq.insert(size);
    }

    public Item pop() {
        Integer index = pq.delMax();
        Item item = items[index];
        if (pq.size() == pq.size() / 4)
            resize(items.length / 2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer index : pq) {
            sb.append(items[index] + " ");
        }
        return sb.toString();
    }

    private class StackIterator implements Iterator<Item> {
        Iterator pqiterator = pq.iterator();

        public boolean hasNext() {
            return pqiterator.hasNext();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Integer index = (Integer) pqiterator.next();
            return items[index];
        }
    }
}
