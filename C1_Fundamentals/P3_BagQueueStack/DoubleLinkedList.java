package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/1/16.
 * Exercise 1.3.31
 */
public class DoubleLinkedList<Item> implements Iterable<Item> {
    private DoubleNode first;
    private DoubleNode last;
    private int size;

    public DoubleLinkedList() {
        first = last = null;
        size = 0;
    }

    public DoubleLinkedList(Item[] items) {
        for (Item i : items) {
            addLast(i);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        DoubleLinkedList<Integer> s = new DoubleLinkedList(arr);

        s.remove(s.getFirst().next);
        StdOut.print(s.toString());

    }

    public DoubleNode getFirst() {
        return first;
    }

    public DoubleNode getLast() {
        return last;
    }

    public void addFirst(Item item) {
        DoubleNode first = new DoubleNode();
        first.item = item;
        if (isEmpty()) {
            this.first = first;
            this.last = first;
            size++;
        } else {
            first.next = this.first;
            this.first.prev = first;
            this.first = first;
            size++;
        }
    }

    public void addLast(Item item) {
        DoubleNode last = new DoubleNode();
        last.item = item;
        if (isEmpty()) {
            this.first = last;
            this.last = last;
            size++;
        } else {
            this.last.next = last;
            last.prev = this.last;
            this.last = last;
            size++;
        }
    }

    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("List is Empty");
        Item item = first.item;
        if (first == last) {
            first = last = null;
        } else {
            first = first.next;
        }
        size--;
        return item;

    }

    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException(("List is Empty"));
        Item item = last.item;
        if (first == last) {
            first = last = null;
        } else {
            last.prev.next = null;
        }
        size--;
        return item;
    }

    public Item remove(DoubleNode a) {
        if (isEmpty())
            throw new NoSuchElementException("List is Empty");
        if (a == first)
            return removeFirst();
        else if (a == last)
            return removeLast();
        else {
            DoubleNode curr = first;
            while (curr != null) {
                if (curr.equals(a)) {
                    Item item = curr.item;
                    DoubleNode prev = curr.prev;
                    prev.next = curr.next;
                    size--;
                    return item;
                }
                curr = curr.next;
            }
            return null;
        }
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

    public Iterator<Item> iterator() {
        return new doubleIterator();
    }

    private class doubleIterator implements Iterator<Item> {
        private DoubleNode curr = first;

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

    private class DoubleNode {
        Item item;
        DoubleNode prev;
        DoubleNode next;

    }
}
