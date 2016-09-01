package P3_BagQueueStack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rliu on 8/31/16.
 */
public class List<Item> implements Iterable<Item> {
    int N;
    Node first;
    Node last;

    public List() {
        first = null;
        last = null;
    }

    public List(Item[] a) {
        first = new Node(a[0]);
        last = first;

        for (int i = 1; i < a.length; i++) {
            Node curr = new Node(a[i]);
            last.next = curr;
            last = curr;
        }
    }

    public List(Iterable<Item> coll) {
        int i = 0;
        coll.forEach(curr -> {
            Node n = new Node(curr);
            if (i == 0) {
                first = n;
                last = first;
            } else {
                last.next = n;
                last = n;
            }
        });
    }

    public static void main(String[] args) {

    }

    public String toString() {
        Node curr = first;
        StringBuffer sb = new StringBuffer();
        while (curr.next != null) {
            sb.append(curr.item).append(" ");
            curr = curr.next;
        }
        return sb.toString();
    }

    public Item getFirst() {
        if (isEmpty())
            throw new RuntimeException("list is empty");
        return first.item;
    }

    public Item getLast() {
        if (isEmpty())
            throw new RuntimeException("list is empty");
        return last.item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public void addFirst(Item item) {
        Node n = new Node(item);
        n.next = first;
        first = n;
        N++;
    }

    public void add(Item item) {
        Node n = new Node(item);
        if (last == null)
            last = n;
        else {
            last.next = n;
            last = n;
        }
        N++;

    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return item;
    }

    /* Exercise 1.3.19*/
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        if (last == first)
            return removeFirst();

        Node curr = first;
        while (curr.next != last) {
            curr = curr.next;
        }
        Item item = curr.item;
        last = curr;
        curr.next = null;
        N--;
        return item;
    }

    /* Exercise 1.3.20 */
    public Item deleteKth(int k) {
        if (isEmpty()) throw new NoSuchElementException();

        Node prev = null;
        prev.next = first;
        Node curr = first;

        int i = 1;
        while (curr != null && i < k) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        if (curr == null)
            return null;
        else {
            Item item = curr.item;
            if (curr == first)
                first = first.next;
            else
                prev.next = curr.next;
            if (curr.next == null)
                last = prev;
            N--;
            return item;
        }
    }

    /* Exercise 1.3.21*/
    public boolean find(Item item) {
        Node curr = first;
        while (curr.next != null) {
            if (curr.item.equals(item))
                return true;
            curr = curr.next;
        }
        return false;
    }

    /* Exercise 1.3.24 */
    public void removeAfter(Node a) {
        Node prev = new Node(first.item);
        prev.next = first;
        Node curr = first;
        while (curr != null && curr != a) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            N--;
            if (curr == first)
                first = first.next;
            else if (curr == last) {
                last = prev;
                last.next = null;
            } else
                prev.next = curr.next;
        }
    }

    /* Exercise 1.3.25 */
    public void insertAfter(Node b) {
        if (first == null) {
            first = b;
        }
        last.next = b;
        Node curr = last;
        while (curr.next != null) {
            N++;
            curr = curr.next;
        }
        last = curr;
    }

    /* Exercise 1.3.26 */
    public void remove(Item item) {
        Node prev = new Node(first.item);
        Node curr = first;
        prev.next = curr;
        Node head = prev;
        while (curr != null) {
            if (curr.item.equals(item)) {
                prev.next = curr.next;
                N--;
            }
            prev = curr;
            curr = curr.next;

        }
        last = prev;
        first = head.next;
    }

    /* Exercise 1.3.27 Assuming the type of Item is Integer */
    public int max() {
        Node curr = first;
        int max = Integer.MIN_VALUE;
        while (curr != null) {
            Integer item = (Integer) curr.item;
            if (item > max)
                max = item;
            curr = curr.next;
        }
        return max;
    }

    /* Exercise 1.3.28 */
    public Item maxRec(Node node) {
        if (node == null)
            throw new RuntimeException("List is Empty");
        if (node.next == null)
            return node.item;
        Item next = maxRec(node.next);
        return ((Comparable) node.item).compareTo(next) > 0 ? node.item : next;
    }

    /* Exercise 1.3.30 */
    public void reverse() {
        Node head = null;
        Node curr = first;
        while (curr != null) {
            Node second = curr.next;
            curr.next = head;
            head = curr;
            curr = second;
        }
        first = head;
    }

    public Node reverse_Rec(Node first) {
        if (first == null) return null;
        if (first.next == null) return first;
        Node second = first.next;
        Node rest = reverse_Rec(second);
        second.next = first;
        first.next = null;
        return rest;
    }

    private class Node {
        Item item;
        Node next;

        Node(Item i) {
            item = i;
            next = null;
        }
    }

    private class ListIterator implements Iterator<Item> {
        private Node curr = first;

        public boolean hasNext() {
            return curr != null;
        }

        public Item next() {
            if (isEmpty()) throw new NoSuchElementException();
            Item i = curr.item;
            curr = curr.next;
            return i;
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

}
