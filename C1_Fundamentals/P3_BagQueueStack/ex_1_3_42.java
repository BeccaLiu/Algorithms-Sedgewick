package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 9/4/16.
 * ex 1.3.42
 */
public class ex_1_3_42<Item> {
    private Node first;
    private int N;

    public ex_1_3_42() {
        first = null;
        N = 0;
    }

    public ex_1_3_42(ex_1_3_42<Item> q) {
        ex_1_3_42<Item> temp = new ex_1_3_42<>();
        while (!q.isEmpty()) {
            temp.push(q.pop());
        }
        while (!temp.isEmpty()) {
            Item item = temp.pop();
            this.push(item);
            q.push(item);
        }
    }

    public static void main(String[] args) {
        ex_1_3_42<Integer> ex1 = new ex_1_3_42<>();
        ex1.push(1);
        ex1.push(2);
        ex1.push(3);
        ex1.push(4);
        ex_1_3_42<Integer> ex2 = new ex_1_3_42<>(ex1);
        StdOut.println(ex1.toString());
        StdOut.println(ex2.toString());
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node temp = first;
        while (temp != null) {
            sb.append(temp.item).append(" ");
            temp = temp.next;
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        if (!isEmpty()) {
            node.next = first;
        }
        first = node;
        N++;
    }

    public Item pop() {
        if (isEmpty())
            throw new UnsupportedOperationException();
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    private class Node {
        Item item;
        Node next;
    }
}
