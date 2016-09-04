package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 9/4/16. ex 1.3.39
 */
public class RingBuffer<Item> {
    Item[] items;
    int N;
    int first;
    int last;

    public RingBuffer(int size) {
        items = (Item[]) new Object[size];
        N = 0;
        first = last = 0;
    }

    public static void main(String[] args) {
        RingBuffer<Integer> rb = new RingBuffer<>(3);
        rb.enqueue(1);
        rb.enqueue(2);
        rb.enqueue(3);
        rb.dequeue();
        rb.enqueue(4);
        StdOut.print(rb);

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(items[(i + first) % items.length]).append(" ");
        }
        return sb.toString();
    }

    public void enqueue(Item i) {
        items[last++] = i;
        if (last == items.length)
            last = 0;
        N++;
    }

    public Item dequeue() {
        Item item = items[first++];
        if (first == items.length)
            first = 0;
        N--;
        return item;
    }
}
