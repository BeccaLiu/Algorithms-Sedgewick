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
public class Steque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    public Steque() {
        first = null;
        last = null;
        size = 0;
    }

    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        steque.push(5);
        StdOut.println(steque + "/" + steque.size());
        steque.enqueue(2);
        StdOut.println(steque + "/" + steque.size());
        steque.pop();
        StdOut.println(steque + "/" + steque.size());
        steque.pop();
        StdOut.println(steque + "/" + steque.size());
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

    public void push(Item item) {
        Node curr = new Node();
        curr.item = item;
        if (isEmpty()) {
            first = last = curr;
            size++;
        } else {
            curr.next = first;
            first = curr;
            size++;
        }
    }

    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        size--;
        Item item = first.item;
        if (first == last) {
            first = last = null;
            return item;
        }
        first = first.next;
        return item;
    }

    public void enqueue(Item item) {
        Node curr = new Node();
        curr.item = item;
        if (isEmpty()) {
            first = last = curr;
            size++;
        } else {
            last.next = curr;
            last = curr;
            size++;
        }
    }

    public Iterator<Item> iterator() {
        return new stequeIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class stequeIterator implements Iterator<Item> {
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
