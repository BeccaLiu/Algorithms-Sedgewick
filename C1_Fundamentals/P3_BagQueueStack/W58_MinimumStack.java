package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/19/16.
 */
public class W58_MinimumStack {
    int size;
    Node last;
    Node minLast;
    Node head = new Node();

    public static void main(String[] args) {
        W58_MinimumStack stack = new W58_MinimumStack();
        for (int i = 0; i < 10; i++) {
            stack.push(StdRandom.uniform(100));
        }
        StdOut.println(stack);

        for (int i = 0; i < 10; i++) {
            StdOut.println(stack.min());
            stack.pop();
        }
    }

    public void push(int a) {
        Node node = new Node();
        node.item = a;
        if (isEmpty()) {
            Node nodemin = new Node();
            nodemin.item = a;
            last = node;
            minLast = nodemin;
            head.next = last;
            last.prev = head;
        } else {
            int min = minLast.item;
            if (a < min) {
                Node nodemin = new Node();
                nodemin.item = a;
                minLast.next = nodemin;
                nodemin.prev = minLast;
            } else {
                Node newMin = new Node();
                newMin.item = min;
                minLast.next = newMin;
                newMin.prev = minLast;
            }

            last.next = node;
            node.prev = last;
            last = last.next;
            minLast = minLast.next;
        }
        size++;
    }

    public int pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        int rt = last.item;
        last = last.prev;
        minLast = minLast.prev;
        size--;
        return rt;
    }

    public int peek() {
        return last.item;
    }

    public int min() {
        return minLast.item;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = head.next;
        while (temp != null) {
            sb.append(temp.item + " ");
            temp = temp.next;
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private class Node {
        int item;
        Node prev;
        Node next;
    }
}
