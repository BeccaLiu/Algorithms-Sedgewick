package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 9/12/16.
 */
public class W34_2StackUseDeque<Item> {
    Deque<Item> dq = new Deque<>();

    public static void main(String[] args) {
        W34_2StackUseDeque<Integer> stackUseDeque = new W34_2StackUseDeque<>();
        W34_2StackUseDeque.Stack1 stack1 = stackUseDeque.new Stack1();
        W34_2StackUseDeque.Stack2 stack2 = stackUseDeque.new Stack2();
        for (int i = 0; i < 10; i++) {
            int temp = StdRandom.uniform(99);
            StdOut.print(temp + " ");
            stack1.push(temp);
            stack2.push(temp + 1);
        }
        StdOut.println();

        for (int i = 0; i < 10; i++) {
            StdOut.print(stack1.pop() + " ");
        }
        StdOut.println();
        for (int i = 0; i < 10; i++) {
            StdOut.print(stack2.pop() + " ");
        }
    }

    class Stack1 {
        public void push(Item item) {
            dq.pushLeft(item);
        }

        public Item pop() {
            return dq.popLeft();
        }
    }

    class Stack2 {
        public void push(Item item) {
            dq.pushRight(item);
        }

        public Item pop() {
            return dq.popRight();
        }
    }
}
