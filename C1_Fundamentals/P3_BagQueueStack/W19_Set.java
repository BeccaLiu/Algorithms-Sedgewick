package P3_BagQueueStack;

import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/8/16.
 */
public class W19_Set {
    Node head;
    private int size;

    public W19_Set() {
        head = null;
        size = 0;
    }

    public static void main(String[] args) {

    }

    public void add(Integer i) {
        Node node = new Node(i);
        if (isEmpty()) {
            head = node;
        } else {
            Node temp = head;
            while (i < temp.item && temp != null) {
                temp = temp.next;
            }
            if (i > temp.item) {
                node.next = temp.next;
                temp.next = node;
            }
        }
        size++;
    }

    public void remove(Integer i) {
        Node temp = head;
        while (i > temp.item) {
            temp = temp.next;
        }
        if (temp.item == i) {
            Node p = temp.prev;
            p.next = temp.next;
            temp.next.prev = temp.prev;
            size--;
        } else {
            throw new NoSuchElementException();
        }

    }

    public boolean exist(Integer i) {
        Node temp = head;
        while (i > temp.item) {
            temp = temp.next;
        }
        return temp.item == i;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public W19_Set intersect(W19_Set set2) {


    }

    public W19_Set difference(W19_Set set2) {

    }

    public W19_Set symmetricDifference(W19_Set set2) {

    }

    public W19_Set union(W19_Set set2) {


    }

    public boolean isSubSet(W19_Set set2) {

    }

    public boolean isSuperSet(W19_Set set2) {

    }

    public boolean isDisjointFrom(W19_Set set2) {

    }

    private class Node {
        Integer item;
        Node next;
        Node prev;

        public Node(Integer i) {
            item = i;
        }
    }
}
