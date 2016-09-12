package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/11/16.
 */
public class W16_17_18_23_Bag<Item> implements Iterable<Item> {
    private Node first;
    private int size;

    public W16_17_18_23_Bag() {
        first = null;
        size = 0;
    }

    public static void main(String[] args) {
        W16_17_18_23_Bag<Integer> bag = new W16_17_18_23_Bag();
        for (int i = 0; i < 10; i++) {
            bag.add(StdRandom.uniform(10));
        }
        StdOut.println(bag.toString());
        StdOut.println(bag.hasDuplicate());
        StdOut.println(bag.hasTriplicate());

        W16_17_18_23_Bag<Integer> bag2 = new W16_17_18_23_Bag();
        for (int i = 0; i < 10; i++) {
            bag2.add(StdRandom.uniform(10));
        }
        StdOut.println(bag2.toString());
        StdOut.println(bag.equals(bag));
        StdOut.println(bag.equals(bag2));
        bag.add(bag2);
        StdOut.println(bag);
        bag.replace(2, 99);
        StdOut.println(bag);
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node curr = first;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public Item next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                Item item = curr.item;
                curr = curr.next;
                return item;
            }
        };
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Item item) {
        Node head = new Node();
        head.item = item;
        head.next = first;
        first = head;
        size++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item i : this) {
            sb.append(i + " ");
        }
        return sb.toString();

    }

    //web_1_3_16
    public boolean hasDuplicate() {
        Iterator<Item> it1 = this.iterator();

        while (it1.hasNext()) {
            Item item = it1.next();
            Iterator<Item> it2 = this.iterator();
            while (it2.hasNext() && it2.next() != item) {
            }
            while (it2.hasNext()) {
                Item temp = it2.next();
                if (item == temp) {
                    return true;
                }
            }
        }
        return false;
    }

    //web_1_3_17
    public boolean hasTriplicate() {
        Iterator<Item> it1 = this.iterator();
        while (it1.hasNext()) {
            Item item = it1.next();
            Iterator<Item> it2 = this.iterator();

            while (it2.hasNext() && it2.next() != item) {
            }
            while (it2.hasNext()) {
                Item item2 = it2.next();
                if (item2 == item) {
                    Iterator<Item> it3 = this.iterator();
                    int i = 0;
                    while (it3.hasNext()) {
                        if (it3.next() == item)
                            i++;
                        if (i == 2)
                            break;
                    }
                    while (it3.hasNext()) {
                        Item item3 = it3.next();
                        if (item3 == item)
                            return true;
                    }
                }
            }
        }
        return false;
    }

    //web_1_3_18
    public boolean Equal(W16_17_18_23_Bag<Item> bag) {
        HashMap<Item, Integer> hashMap = new HashMap<>();
        for (Item i : this) {
            if (hashMap.containsKey(i))
                hashMap.put(i, hashMap.get(i) + 1);
            else {
                hashMap.put(i, 1);
            }
        }
        for (Item i : bag) {
            if (hashMap.containsKey(i)) {
                int count = hashMap.get(i) - 1;
                if (count < 0)
                    return false;
                hashMap.put(i, count);
            } else
                return false;
        }
        return true;
    }

    //web_1_3_23
    public void add(W16_17_18_23_Bag bag2) {
        Node curr = first;
        while (curr.next != null) {
            curr = curr.next;
        }
        Iterator<Item> it = bag2.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            Node node = new Node();
            node.item = item;
            curr.next = node;
            curr = curr.next;
        }

    }

    //web_1_3_24
    public void replace(Item from, Item to) {
        Node curr = first;
        while (curr != null) {
            if (curr.item == from)
                curr.item = to;
            curr = curr.next;
        }
    }

    private class Node {
        Item item = null;
        Node next = null;
    }
}
