package P3_BagQueueStack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 9/4/16.
 * Queue with three stacks
 * | | | |3| | | |
 * | | | |_| | | |
 * | | |_____| | |
 * | |         | |
 * | |   |2|   | |
 * | |   |_|   | |
 * | |_________| |
 * |             |
 * |     |1|     |
 * |     |_|     |
 * |_____________|
 */
public class ex_1_3_49<Item> {
    Stack<Stack<Item>> queue;
    Stack<Stack<Item>> nested;
    Stack temp;
    int size;

    public ex_1_3_49() {
        int size = 0;
        queue = new Stack<Stack<Item>>();
        nested = queue;
        temp = new Stack<Item>();
    }

    public static void main(String[] args) {
        ex_1_3_49<Integer> queue = new ex_1_3_49<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        temp.push(item);
        nested.push(temp);
        temp = new Stack<Stack<Item>>();
        nested.push(temp);
        nested = temp;
        size++;
    }

    public Item dequeue() {
        temp = queue.pop();
        Item item = queue.pop().pop();
        queue = temp;
        size--;
        return item;
    }

}
