package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 9/4/16. ex. 1.3.40
 */
public class MoveToFront<Item> {
    private int N;
    private Node first;

    public MoveToFront() {
        N = 0;
        first = null;
    }

    public static void main(String[] args) {
        MoveToFront<Character> mtf = new MoveToFront<>();
        while (!StdIn.isEmpty()) {
            mtf.insert(StdIn.readChar());
            StdOut.println(mtf.toString());
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Item item) {
        Node head = new Node();
        head.item = item;
        if (isEmpty()) {
            first = head;
            N++;
        } else {
            checkDupAndRemove(item);
            head.next = first;
            first = head;
            N++;
        }
    }

    private void checkDupAndRemove(Item item) {
        if (first.item == item)
            first = first.next;
        else {
            Node curr = first;
            while (curr.next != null) {
                if (curr.next.item == item) {
                    curr.next = curr.next.next;
                    break;
                }
                curr = curr.next;
            }
        }
    }

    public String toString() {
        Node node = first;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.item).append(" ");
            node = node.next;
        }
        return sb.toString();
    }

    private class Node {
        Item item;
        Node next = null;
    }
}

