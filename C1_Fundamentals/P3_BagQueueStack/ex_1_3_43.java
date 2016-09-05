package P3_BagQueueStack;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * Created by rliu on 9/4/16.
 */
public class ex_1_3_43 {
    private static Queue<File> directory = new Queue<File>();

    public static Queue<File> getFile(File file) {
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                directory.enqueue(file2);
                getFile(file2);
            } else {
                directory.enqueue(file2);
            }
        }
        return directory;
    }

    public static void main(String[] args) {
        File file = new File("C1_Fundamentals");//路径自己设置
        StdOut.print(getFile(file));
    }
}
