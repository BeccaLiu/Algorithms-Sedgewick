package P3_BagQueueStack;

import edu.princeton.cs.algs4.Stack;

/**
 * Created by rliu on 9/7/16.
 */
public class W9_TuringTape {
    int activeCell;
    Stack<Integer> tapeLeft;
    Stack<Integer> taperRight;

    W9_TuringTape() {
        tapeLeft = new Stack<>();
        taperRight = new Stack<>();
    }

    public void moveRight() {
        tapeLeft.push(activeCell);
        activeCell = taperRight.pop();
    }

    public void moveLeft() {
        taperRight.push(activeCell);
        activeCell = tapeLeft.pop();
    }

    public void write(int a) {
        activeCell = a;
    }

    public int look() {
        return activeCell;
    }
}
