package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/3/16.
 * ex1.3.35 ex 1.3.36
 */
public class RandomQueue<Item> implements Iterable<Item> {
    Item[] items;
    int N;
    int first;
    int last;

    public RandomQueue() {
        items = (Item[]) new Object[2];
        N = 0;
        first = last = 0;
    }

    public static void main(String[] args) {
        RandomQueue<Integer> rd = new RandomQueue<>();
        for (int i = 0; i < 10; i++)
            rd.enqueue(StdRandom.uniform(100));
        StdOut.println(rd);
        StdOut.println(rd.dequeue());
        StdOut.println(rd);
        StdOut.println(rd.dequeue());
        StdOut.println(rd);
        for (Integer i : rd) {
            StdOut.print(i + " ");
        }

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(items[(first + i) % items.length]).append(" ");
        }
        return sb.toString();
    }

    private void resize(int length) {
        Item[] temp = (Item[]) new Object[length];
        for (int i = 0; i < N; i++) {
            temp[i] = items[(first + i) % items.length];
        }
        items = temp;
        first = 0;
        last = N;
    }

    public void enqueue(Item item) {
        if (N == items.length)
            resize(items.length * 2);
        items[last++] = item;
        if (last == items.length)
            last = 0;
        N++;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int index = (first + StdRandom.uniform(0, N)) % items.length;
        Item random = items[index];
        items[index] = items[first];
        items[first] = null;
        N--;

        if (first == items.length)
            first = 0;
        else
            first++;
        if (N > 0 && N == items.length / 4)
            resize(items.length / 2);
        return random;
    }

    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty!");
        int index = (first + StdRandom.uniform(0, N)) % items.length;
        return items[index];
    }

    public Iterator<Item> iterator() {
        return new randomIterator();
    }

    private class randomIterator implements Iterator<Item> {
        Item[] temp = (Item[]) new Object[items.length];
        int i = first;

        public randomIterator() {
            for (int j = 0; j < N; j++) {
                int index = (first + StdRandom.uniform(j, N)) % items.length;
                temp[j] = items[index];
                items[index] = items[(first + j) % items.length];
            }
        }

        public boolean hasNext() {
            return i != N;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            Item item = temp[i];
            i++;
            return item;
        }

    }


}
