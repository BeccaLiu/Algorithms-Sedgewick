import edu.princeton.cs.algs4.StdOut;

/*
Write a program that reads in lines from standard input with each line containing a name and two integers and then uses printf() to print a table with a column of the names, the integers, and the result of dividing the first by the second, accurate to three decimal places. You could use a program like this to tabulate batting averages for baseball players or grades for students.
 */
public class ex_1_1_22 {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7};
        rank(6, array, 0, array.length - 1, 1);
    }

    public static int rank(int key, int[] a, int lo, int hi, int depth) {  // Index of key in a[], if present, is not smaller than lo and not larger than hi.
        StdOut.println(depth + ":" + lo + "/" + hi);
        depth++;
        if (lo > hi) return -1;

        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return rank(key, a, lo, mid - 1, depth);
        else if (key > a[mid])
            return rank(key, a, mid + 1, hi, depth);
        else return mid;
    }
}