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
 * ex 1.3.33
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
        deque.popLeft();
        StdOut.println(deque.size() + "/" + deque);
        deque.popLeft();
        StdOut.println(deque.size() + "/" + deque);
        deque.popRight();
        StdOut.println(deque.size() + "/" + deque);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            sb.append(arr[(first + i) % arr.length]).append(" ");
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
        for (int i = 0; i < size; i++) {
            temp[i] = arr[(i + first + 1) % arr.length];
        }
        arr = temp;
        first = arr.length - 1;
        last = size;
    }

    public void pushLeft(Item item) {
        if (size == arr.length)
            resize(arr.length * 2);
        arr[first--] = item;
        if (first == -1)
            first = arr.length - 1;
        size++;
    }

    public Item popLeft() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item item = arr[first];
        arr[first] = null;
        first++;
        size--;
        if (first == arr.length)
            first = 0;
        if (size > 0 && size == arr.length / 4)
            resize(arr.length / 2);
        return item;
    }

    public void pushRight(Item item) {
        if (size == arr.length)
            resize(arr.length * 2);
        if (arr[last] != null)
            arr[(++last) % arr.length] = item;
        else
            arr[last++] = item;
        if (last == arr.length)
            last = 0;
        size++;
    }

    public Item popRight() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item item = arr[last--];
        arr[last + 1] = null;
        size--;
        if (last == 0)
            last = arr.length - 1;
        if (size > 0 && size == arr.length / 4)
            resize(arr.length / 2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new dequeIterator();
    }

    private class dequeIterator implements Iterator<Item> {
        private int index = first;

        public boolean hasNext() {
            return index % arr.length == size;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            Item item = arr[index % arr.length];
            index++;
            return item;
        }
    }
}
