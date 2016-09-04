package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * Created by rliu on 9/3/16.
 */
public class RandomBag<Item> implements Iterable<Item> {
    private Node first;
    private int size;

    public RandomBag() {
        first = null;
        size = 0;
    }

    public static void main(String[] args) {
        RandomBag<Integer> rb = new RandomBag<Integer>();
        rb.add(1);
        rb.add(2);
        rb.add(3);
        rb.add(4);
        rb.add(5);
        rb.add(6);
        rb.add(7);
        rb.add(8);
        for (Integer i : rb) {
            StdOut.print(i + " ");
        }

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Item item) {
        Node head = new Node();
        head.item = item;
        head.next = first;
        first = head;
        size++;
    }

    public Iterator<Item> iterator() {
        return new randomBagIterator();
    }

    private class randomBagIterator implements Iterator<Item> {
        int i = 0;
        private Item[] items = null;

        public randomBagIterator() {
            items = (Item[]) new Object[size];
            Node temp = first;
            int j = 0;
            while (temp != null) {
                items[j] = temp.item;
                j++;
                temp = temp.next;
            }
            shuffle();

        }

        private void shuffle() {
            for (int i = 0; i < size; i++) {
                int index = StdRandom.uniform(i, size);
                Item temp = items[i];
                items[i] = items[index];
                items[index] = temp;
            }
        }

        public boolean hasNext() {
            return i != size;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove is not supportted");
        }

        public Item next() {
            Item item = items[i];
            i++;
            return item;
        }
    }

    private class Node {
        Item item = null;
        Node next = null;
    }

}
