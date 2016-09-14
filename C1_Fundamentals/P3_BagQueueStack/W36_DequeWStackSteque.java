package P3_BagQueueStack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/12/16.
 * unfinished..
 */
public class W36_DequeWStackSteque<Item> {
    Stack<Item> stack = new Stack<Item>();//handle left
    Steque<Item> steque = new Steque<Item>();//handel right
    private int sizeLeft;
    private int sizeRight;

    public static void main(String[] args) {
        W36_DequeWStackSteque<Integer> dWStackSteque = new W36_DequeWStackSteque<>();
        dWStackSteque.pushRight(1);
        dWStackSteque.pushRight(2);
        dWStackSteque.pushLeft(3);
        dWStackSteque.pushLeft(4);
        StdOut.println(dWStackSteque.popLeft());
        StdOut.println(dWStackSteque.popLeft());
        StdOut.println(dWStackSteque.popLeft());
        dWStackSteque.pushLeft(5);
        dWStackSteque.pushLeft(6);
        StdOut.println(dWStackSteque.popRight());
        StdOut.println(dWStackSteque.popRight());
        StdOut.println(dWStackSteque.popRight());
    }

    public boolean isEmpty() {
        return sizeLeft + sizeRight == 0;
    }

    public int size() {
        return sizeLeft + sizeRight;
    }

    public void pushLeft(Item item) {
        stack.push(item);
        steque.enqueue(item);
        sizeLeft++;
    }

    public Item popLeft() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (sizeLeft == 0) {
            while (!stack.isEmpty())
                stack.pop();
            int size = sizeRight;
            for (int i = 0; i < size; i++) {
                Item item = steque.pop();
                sizeRight--;
                steque.enqueue(item);
                stack.push(item);
                sizeLeft++;
            }
            int stequeSize = steque.size();
            for (int i = 0; i < stequeSize - size; i++) {
                steque.pop();
            }
        }
        sizeLeft--;
        return stack.pop();
    }

    public void pushRight(Item item) {
        steque.push(item);
        sizeRight++;
    }

    public Item popRight() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (sizeRight == 0) {
            int size = stack.size() - sizeLeft;
            for (int i = 0; i < size; i++) {
                steque.pop();
            }
            sizeLeft--;
            return steque.pop();
        } else {
            sizeRight--;
            return steque.pop();
        }
    }
}
