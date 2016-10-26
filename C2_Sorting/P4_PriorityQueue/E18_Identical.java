package P4_PriorityQueue;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 10/25/16.
 * when insert a biggest item in the MaxPQ, the item will swim up, to the top of the heap of int arr[1];
 * when delMax happens, move the arr[N] to arr[1], and sink(1), which is check arr[1*2] and arr[1*2+1] which is bigger, as the bigger one is the one moving from previous level to current level, which means move everything back as previous.
 */
public class E18_Identical {
    public static void main(String[] args) {
        int N = 15;
        MaxPQ<Integer> pq = new MaxPQ<>();
        for (int i = 0; i < N; i++) {
            pq.insert(StdRandom.uniform(100));
        }
        StdOut.println(pq);
        pq.insert(101);
        pq.delMax();
        StdOut.println(pq); //should be identical to the original pq

        pq.insert(101);
        pq.insert(102);
        pq.delMax();
        pq.delMax();
        StdOut.println(pq);
    }
}
