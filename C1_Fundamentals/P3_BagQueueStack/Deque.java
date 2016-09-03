package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/2/16.
 * A stack-ended queue or steque is a data type that supports push, pop, and enqueue(inject).
 * push: addFirst
 * pop:removeFirst
 * inject:addLast
 * eject:removeLast
 */
public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.pushLeft(3);
        deque.pushLeft(5);
        StdOut.println(deque + "/" + deque.size());
        deque.pushRight(2);
        StdOut.println(deque + "/" + deque.size());
        deque.popLeft();
        StdOut.println(deque + "/" + deque.size());
        deque.popRight();
        StdOut.println(deque + "/" + deque.size());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : this) {
            sb.append(item).append(" ");
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void pushLeft(Item item) {
        Node curr = new Node();
        curr.item = item;
        if (isEmpty()) {
            first = last = curr;
            size++;
        } else {
            curr.next = first;
            first.prev = curr;
            first = curr;
            size++;
        }
    }

    public Item popLeft() {
        if (isEmpty())
            throw new NoSuchElementException();
        size--;
        Item item = first.item;
        if (first == last) {
            first = last = null;
            return item;
        }
        first = first.next;
        first.prev = null;
        return item;
    }

    public void pushRight(Item item) {
        Node curr = new Node();
        curr.item = item;
        if (isEmpty()) {
            first = last = curr;
            size++;
        } else {
            last.next = curr;
            curr.prev = last;
            last = curr;
            size++;
        }
    }

    public Item popRight() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item item = last.item;
        if (first == last) {
            first = last = null;
            return item;
        }
        last = last.prev;
        last.next = null;
        return item;
    }

    public Iterator<Item> iterator() {
        return new dequeIterator();
    }

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private class dequeIterator implements Iterator<Item> {
        private Node curr = first;

        public boolean hasNext() {
            return curr != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
    }
}
