package P3_BagQueueStack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/12/16.
 */
public class W35_SteqUse2Stack<Item> {
    Stack<Item> s1 = new Stack<>();
    Stack<Item> s2 = new Stack<>();

    public static void main(String[] args) {
        W35_SteqUse2Stack<Integer> steque = new W35_SteqUse2Stack();
        for (int i = 0; i < 10; i++) {
            int temp = StdRandom.uniform(20);
            StdOut.print(temp + " ");
            steque.enqueue(temp);
            steque.push(temp);

        }
        StdOut.println();
        while (!steque.isEmpty()) {
            StdOut.print(steque.pop() + " ");
        }
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public int size() {
        return s1.size() + s2.size();
    }

    public void push(Item item) {
        s1.push(item);
    }

    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (s1.isEmpty()) {
            while (!s2.isEmpty())
                s1.push(s2.pop());
        }
        return s1.pop();
    }

    public void enqueue(Item item) {
        s2.push(item);
    }
}
