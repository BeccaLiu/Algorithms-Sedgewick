package P3_BagQueueStack;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedHashMap;

/**
 * Created by rliu on 9/14/16.
 */
public class W38_MultiWords {
    public static void main(String[] args) {
        StdOut.print("Input Documents Word:");
        String[] d = StdIn.readAllStrings();

        LinkedHashMap<String, Queue<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < args.length; i++) {
            map.put(args[i], new Queue<Integer>());
        }
        for (int i = 0; i < d.length; i++) {
            if (map.containsKey(d[i]))
                map.get(d[i]).enqueue(i);
        }
        Queue<Integer>[] arr = map.values().toArray(new Queue[map.size()]);
        int bestlo = -1;
        int besthi = d.length;
        boolean isHighestIndexFound = true;
        while (!arr[0].isEmpty()) {
            int lo = arr[0].dequeue(); //current lowest index
            int hi = lo; //currently highest index, will update every following iteration
            for (int i = 1; i < arr.length; i++) {
                while (!arr[i].isEmpty() && arr[i].peek() <= hi) {
                    arr[i].dequeue();
                }
                if (arr[i].isEmpty()) {
                    isHighestIndexFound = false;
                    break;
                } else
                    hi = arr[i].peek();
            }
            if (isHighestIndexFound) {
                if (hi - lo < besthi - bestlo) {
                    bestlo = lo;
                    besthi = hi;
                }
            } else {
                break;
            }

        }
        if (bestlo != -1) {
            for (int i = bestlo; i <= besthi; i++)
                StdOut.print(d[i] + " ");

        } else {
            StdOut.println("Not Found");
        }
    }
}

