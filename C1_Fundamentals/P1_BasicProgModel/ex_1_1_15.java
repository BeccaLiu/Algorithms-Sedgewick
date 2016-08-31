import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ex_1_1_15 {
    public static void main(String[] args) {
        StdOut.print("input array, separate by space:");
        String input = StdIn.readLine();
        StdOut.print("input M:");
        int M = StdIn.readInt();
        String[] temp = input.split(" ");
        int[] a = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            a[i] = Integer.parseInt(temp[i]);
        }
        histogram(a, M);
    }

    public static int[] histogram(int[] a, int M) {
        int[] histogram = new int[M];
        for (int i : a) {
            if (i < M)
                histogram[i]++;
        }
        return histogram;
    }
}