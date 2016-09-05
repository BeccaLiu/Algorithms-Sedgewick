package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/2/16.
 * A stack-ended queue or steque is a data type that supports push, pop, and enqueue(inject).
 * push: addFirst
 * pop:removeFirst
 * inject:addLast
 * eject:removeLast
 * 1.3.32
 */
public class Steque<Item> implements Iterable<Item> {
    protected transient int modCount = 0;
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
        StdOut.println(steque.size() + "/" + steque);
        steque.enqueue(2);
        StdOut.println(steque.size() + "/" + steque);
        steque.enqueue(3);
        StdOut.println(steque.size() + "/" + steque);

        Iterator<Integer> it = steque.iterator();

        while (it.hasNext()) {
            Integer integer = it.next();
            steque.push(4);      //This will throw ConcurrentModificationException
        }

        StdOut.println(steque.size() + "/" + steque);

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
        modCount++;
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
        modCount++;
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
        modCount++;
    }

    public Iterator<Item> iterator() {
        return new stequeIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class stequeIterator implements Iterator<Item> {
        int expectedModCount = modCount;
        private Node curr = first;

        public boolean hasNext() {
            return curr != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException();
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
    }
}
