package P3_BagQueueStack;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 9/13/16.
 */
public class W33_StackWithQueue<Item> {
    Queue<Item> q = new Queue<>();

    public static void main(String[] args) {
        W33_StackWithQueue<Integer> stack = new W33_StackWithQueue<>();
        for (int i = 0; i < 5; i++) {
            int j = StdRandom.uniform(10);
            StdOut.print(j + " ");
            stack.push(j);
        }
        StdOut.println();
        for (int i = 0; i < 5; i++) {
            StdOut.print(stack.pop() + " ");
        }
    }

    public int size() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public void push(Item item) {
        q.enqueue(item);
    }

    public Item pop() {
        int s = q.size();
        for (int i = 0; i < s - 1; i++) {
            q.enqueue(q.dequeue());
        }
        return q.dequeue();
    }
}
