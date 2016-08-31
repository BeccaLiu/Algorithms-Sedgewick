package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rliu on 8/30/16.
 */
public class ResizingArrayQueueOfStrings implements Iterable {
    private String[] arr;
    private int N;

    public ResizingArrayQueueOfStrings() {
        arr = new String[2];
        N = 0;
    }

    public static void main(String[] args) {
        //using data from ex.1.3.8 to test : it was - the best - of times - - - it was - the - -
        ResizingArrayQueueOfStrings rq = new ResizingArrayQueueOfStrings();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-"))
                rq.dequeue();
            else
                rq.enqueue(s);
            StdOut.println(rq.arr.length + "/" + rq.N + "/" + rq);
        }
    }

    public boolean isEmpty() {
        return N <= 0;
    }

    public int size() {
        return N;
    }

    private void resize(int capacity) {
        String[] temp = new String[capacity];
        for (int i = 0; i < arr.length && i < capacity; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void enqueue(String a) {
        if (N == arr.length)
            resize(arr.length * 2);
        arr[N++] = a;
    }

    public String dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Stack Underflow");
        String curr = arr[--N];
        arr[N] = null;

        if (N > 0 && N == arr.length / 4)
            resize(arr.length / 2);
        return curr;
    }

    public String peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack Underflow");
        return arr[N - 1];
    }

    public Iterator iterator() {
        return new ArrayIterator();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private class ArrayIterator implements Iterator {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public String next() {
            if (isEmpty())
                throw new NoSuchElementException("Stack Underflow");
            String s = arr[i++];
            return s;
        }
    }
}
