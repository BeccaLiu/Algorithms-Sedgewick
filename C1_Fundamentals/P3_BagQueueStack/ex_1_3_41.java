package P3_BagQueueStack;


import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/4/16.
 */
public class ex_1_3_41<Item> {
    private int N;
    private Node first;
    private Node last;

    public ex_1_3_41() {
        N = 0;
        first = last = null;
    }

    public ex_1_3_41(ex_1_3_41<Item> q) {
        first = last = null;
        N = 0;
        Node curr = q.first;
        int i = 0;
        while (i < q.N) {
            i++;
            Item item = q.dequeue();
            this.enqueue(item);
            q.enqueue(item);
        }

    }

    public static void main(String[] args) {
        ex_1_3_41<Integer> ex1 = new ex_1_3_41<>();
        ex1.enqueue(1);
        ex1.enqueue(2);
        ex1.enqueue(3);
        ex1.enqueue(4);
        ex1.enqueue(5);
        ex_1_3_41<Integer> ex2 = new ex_1_3_41<>(ex1);
        StdOut.println(ex1.toString());
        StdOut.println(ex2.toString());


    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = first;
        while (curr != null) {
            sb.append(curr.item).append(" ");
            curr = curr.next;
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty())
            first = last = node;
        else
            last.next = node;
        last = node;
        N++;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item item = first.item;
        if (first == last)
            first = last = null;
        else
            first = first.next;
        N--;
        return item;
    }

    private class Node {
        Item item;
        Node next;
    }
}
