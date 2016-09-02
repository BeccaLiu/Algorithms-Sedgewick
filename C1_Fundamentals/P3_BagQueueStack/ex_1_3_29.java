package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/1/16.
 */
class CircularList<Item> implements Iterable<Item> {
    Node last;
    int N;

    public CircularList() {
        last = null;
        N = 0;
    }

    public static void main(String[] args) {
        CircularList<Integer> cl = new CircularList<>();
        cl.enqueue(1);
        cl.enqueue(2);
        StdOut.println(cl.size() + "/" + cl.toString());
        cl.dequeue();
        cl.dequeue();
        cl.dequeue();
        StdOut.println(cl.size() + "/" + cl.toString());
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        Node insert = new Node();
        insert.item = item;
        if (isEmpty()) {
            last = insert;
            last.next = last;
        } else {
            Node first = last.next;
            last.next = insert;
            insert.next = first;
            last = insert;
        }
        N++;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (last == last.next) {
            Item i = last.item;
            last = null;
            N--;
            return i;
        } else {
            Node first = last.next;
            Item i = first.item;
            last.next = first.next;
            N--;
            return i;
        }
    }

    public String toString() {
        if (isEmpty())
            return "";
        StringBuffer sb = new StringBuffer();
        int i = 0;
        Node curr = last.next;
        while (i < N) {
            sb.append(curr.item);
            sb.append(" ");
            curr = curr.next;
            i++;
        }
        return sb.toString();
    }

    public Iterator<Item> iterator() {
        return new listIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class listIterator implements Iterator<Item> {
        private Node curr = last.next;
        private int i = 0;

        public boolean hasNext() {
            return i != N;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (isEmpty()) throw new NoSuchElementException();
            Item item = curr.item;
            curr = curr.next;
            i++;
            return item;
        }
    }
}
