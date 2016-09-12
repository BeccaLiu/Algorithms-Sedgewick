package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/11/16.
 */
public class W22_TwoWayIterator<Item> implements Iterable<Item> {
    private Node pre;
    private Node post;
    private int size;

    public W22_TwoWayIterator() {
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
    }

    public static void main(String[] args) {
        W22_TwoWayIterator<Integer> list = new W22_TwoWayIterator<Integer>();
        for (int i = 0; i < 10; i++)
            list.add(StdRandom.uniform(100));
        StdOut.println(list);
        StdOut.println();

        TwoWayIterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            StdOut.print(it.next() + " ");
        }
        StdOut.println();

        while (it.hasPrevious()) {
            StdOut.print(it.previous() + " ");
        }

    }

    public void add(Item item) {
        Node node = new Node();
        node.item = item;
        Node last = post.prev;
        last.next = node;
        node.next = post;
        post.prev = node;
        node.prev = last;

        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public TwoWayIterator<Item> iterator() {
        return new TwoWayIterators();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item i : this) {
            sb.append(i + " ");
        }
        return sb.toString();
    }

    private interface TwoWayIterator<Item> extends Iterator<Item> {
        boolean hasNext();

        Item next();

        boolean hasPrevious();

        Item previous();
    }

    private class Node {
        Item item;
        Node prev;
        Node next;
    }

    private class TwoWayIterators implements TwoWayIterator<Item> {
        Node curr = pre.next;
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = curr.item;
            curr = curr.next;
            index++;
            return item;
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public Item previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            curr = curr.prev;
            index--;
            Item item = curr.item;
            return item;
        }
    }
}
