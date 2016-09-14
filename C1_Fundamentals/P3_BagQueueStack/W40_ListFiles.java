package P3_BagQueueStack;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * Created by rliu on 9/14/16.
 */
public class W40_ListFiles {
    public static void main(String[] args) {
        File file = new File("C1_Fundamentals");
        Queue<File> q = new Queue<>();
        q.enqueue(file);
        while (!q.isEmpty()) {
            File f = q.dequeue();
            if (f.isDirectory()) {
                File[] files = f.listFiles();
                if (files != null) {
                    for (int i = 0; i < files.length; i++) {
                        q.enqueue(files[i]);
                    }
                }
            } else {
                StdOut.println(f.length() + " " + f + " ");
            }
        }
    }
}
