package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/2/16.
 * A stack-ended queue or steque is a data type that supports push, pop, and enqueue(inject).
 * push: addFirst
 * pop:removeFirst
 * inject:addLast
 * eject:removeLast
 */
public class ResizingArrayDeque<Item> implements Iterable<Item> {
    private Item[] arr;
    private int size;
    private int first;
    private int last;

    public ResizingArrayDeque() {
        arr = (Item[]) new Object[2];
        size = 0;
        first = 0;
        last = 1;
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();
        deque.pushLeft(3);
        StdOut.println(deque.size() + "/" + deque);
        deque.pushRight(4);
        StdOut.println(deque.size() + "/" + deque);
        deque.pushLeft(2);
        StdOut.println(deque.size() + "/" + deque);
        deque.pushLeft(1);
        StdOut.println(deque.size() + "/" + deque);
        deque.pushRight(5);
        StdOut.println(deque.size() + "/" + deque);
        deque.popLeft();
        StdOut.println(deque.size() + "/" + deque);
        deque.popRight();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = first; i < first + size; i++) {
            sb.append(arr[i]).append(" ");
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int length) {
        Item[] temp = (Item[]) new Object[length];
        int index = (length - size) / 2;
        for (int i = first; i <= last; i++) {
            temp[index] = arr[i];
            index++;
        }
        arr = temp;
        first = (length - size) / 2;
        last = (length - size) / 2 + size;
        StdOut.println(first + "f/l" + last + " in " + arr.length);

    }

    public void pushLeft(Item item) {
        if (arr[0] != null)
            resize(arr.length * 2);
        if (arr[first] == null) {
            arr[first] = item;
        } else {
            arr[--first] = item;
        }
        size++;
    }

    public Item popLeft() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item item = arr[first++];
        arr[first - 1] = null;
        size--;
        if (size > 0 && size == arr.length / 4)
            resize(arr.length / 2);
        return item;
    }

    public void pushRight(Item item) {
        if (arr[arr.length - 1] != null)
            resize(arr.length * 2);
        if (arr[last] == null)
            arr[last] = item;
        else {
            arr[++last] = item;
        }
        size++;
    }

    public Item popRight() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item item = arr[last--];
        arr[last + 1] = null;
        size--;
        if (size > 0 && size == arr.length / 4)
            resize(arr.length / 2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new dequeIterator();
    }

    private class dequeIterator implements Iterator<Item> {
        private int index = 0;

        public boolean hasNext() {
            return index == size;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            Item item = arr[index];
            index++;
            return item;
        }
    }
}
