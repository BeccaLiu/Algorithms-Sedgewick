package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/12/16.
 */
public class W29_CircularQueue<Item> {
    int size;
    private Node last;

    public static void main(String[] args) {
        W29_CircularQueue<Integer> cq = new W29_CircularQueue();

        for (int i = 0; i < 10; i++) {
            int temp = StdRandom.uniform(10);
            StdOut.print(temp + " ");
            cq.enqueue(temp);
        }
        StdOut.println();
        for (int i = 0; i < 10; i++) {
            StdOut.print(cq.dequeue() + " ");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            last = node;
            last.next = last;
        } else {
            Node head = last.next;
            last.next = node;
            node.next = head;
            last = node;
        }
        size++;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (last.next == last) {
            Item item = last.item;
            last = null;
            size--;
            return item;
        }
        Item dq = last.next.item;
        Node newhead = last.next.next;
        last.next = newhead;
        size--;
        return dq;
    }

    private class Node {
        Node next;
        Item item;
    }
}
