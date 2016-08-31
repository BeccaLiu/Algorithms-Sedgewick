package P3_BagQueueStack;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

/**
 * Created by rliu on 8/31/16.
 * write a static method readDates()for Date that reads dates from standard input in the format specified in the table on page 119 and returns an array containing them
 */
public class ex_1_3_16 {
    public static void main(String[] args) {
        Date[] dates = readDates();
    }

    public static Date[] readDates() {
        Queue<Date> q = new Queue<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            String[] content = s.split("/");
            Date date = new Date(Integer.parseInt(content[0]), Integer.parseInt(content[1]), Integer.parseInt(content[2]));
            q.enqueue(date);
        }
        int N = q.size();
        Date[] dates = new Date[N];
        for (int i = 0; i < N; i++) {
            dates[i] = q.dequeue();
        }
        return dates;
    }
}
