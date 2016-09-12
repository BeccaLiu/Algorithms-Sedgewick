package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/11/16.
 */
public class W21_DoublyLinkedList<Item> implements Iterable<Item> {
    private Node pre;
    private Node post;
    private int size;

    W21_DoublyLinkedList() {
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;

    }

    public static void main(String[] args) {
        int n = 10;

        // add elements 1, ..., n
        StdOut.println(n + " random integers between 0 and 99");
        W21_DoublyLinkedList<Integer> list = new W21_DoublyLinkedList<Integer>();
        for (int i = 0; i < n; i++)
            list.add(StdRandom.uniform(100));
        StdOut.println(list);
        StdOut.println();

        ListIterator<Integer> iterator = list.iterator();

        // go forwards with next() and set()
        StdOut.println("add 1 to each element via next() and set()");
        while (iterator.hasNext()) {
            int x = iterator.next();
            iterator.set(x + 1);
        }
        StdOut.println(list);
        StdOut.println();

        // go backwards with previous() and set()
        StdOut.println("multiply each element by 3 via previous() and set()");
        while (iterator.hasPrevious()) {
            int x = iterator.previous();
            iterator.set(x + x + x);
        }
        StdOut.println(list);
        StdOut.println();


        // remove all elements that are multiples of 4 via next() and remove()
        StdOut.println("remove elements that are a multiple of 4 via next() and remove()");
        while (iterator.hasNext()) {
            int x = iterator.next();
            if (x % 4 == 0) iterator.remove();
        }
        StdOut.println(list);
        StdOut.println();


        // remove all even elements via previous() and remove()
        StdOut.println("remove elements that are even via previous() and remove()");
        while (iterator.hasPrevious()) {
            int x = iterator.previous();
            if (x % 2 == 0) iterator.remove();
        }
        StdOut.println(list);
        StdOut.println();


        // add elements via next() and add()
        StdOut.println("add elements via next() and add()");
        while (iterator.hasNext()) {
            int x = iterator.next();
            iterator.add(x + 1);
        }
        StdOut.println(list);
        StdOut.println();

        // add elements via previous() and add()
        StdOut.println("add elements via previous() and add()");
        while (iterator.hasPrevious()) {
            int x = iterator.previous();
            iterator.add(x * 10);
            iterator.previous();
        }
        StdOut.println(list);
        StdOut.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Item item) {
        Node node = new Node();
        node.item = item;
        Node last = post.prev;
        node.prev = last;
        node.next = post;
        last.next = node;
        post.prev = node;
        size++;
    }

    public ListIterator<Item> iterator() {
        return new iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item i : this) {
            sb.append(i + " ");
        }
        return sb.toString();
    }

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private class iterator implements ListIterator<Item> {
        private Node curr = pre.next;
        private Node lastAccess = null;
        private int index = 0;


        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastAccess = curr;
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
            lastAccess = curr;
            Item item = curr.item;
            index--;
            return item;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        // remove the element that was last accessed by next() or previous()
        // condition: no calls to remove() or add() after last call to next() or previous()
        @Override
        public void remove() { //it is only legal to call set() and remove() after a call either to next() or previous()
            if (lastAccess == null)
                throw new IllegalStateException();
            Node p = lastAccess.prev;
            Node n = lastAccess.next;
            p.next = n;
            n.prev = p;
            size--;
            if (curr == lastAccess) //when tracking backwards using previous(), curr=lastAccess, and if delete lastAccess, means lastAcess.next will move one spot up, and the curr will point to lastAccess.next, and the index will stay the same.
                curr = n;
            else
                index--;
            lastAccess = null;
        }

        @Override
        public void set(Item item) { //overwrites the value of the last element returned by either next() or previous();
            if (lastAccess == null)
                throw new IllegalStateException();
            lastAccess.item = item;
        }

        @Override
        public void add(Item item) { //inserts an element before the next element that would be returned by next(); because is insert before next so here we do not care about if lastaccess is null or not
            Node node = new Node();
            node.item = item;
            Node p = curr.prev;
            node.prev = p;
            node.next = curr;
            p.next = node;
            curr.prev = node;
            index++;
            size++;
            lastAccess = null;//in case add then remove without trigger next();
        }
    }


}
