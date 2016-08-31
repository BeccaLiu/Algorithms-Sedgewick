package P2_DataAbstraction;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 8/27/16.
 */
public class SmartDate {
    private final int month;
    private final int day;
    private final int year;

    public SmartDate(int y, int m, int d) {
        validate(y, m, d);
        year = y;
        month = m;
        day = d;
    }

    public static void main(String[] args) {
        StdOut.print("input year: ");
        int year = StdIn.readInt();
        StdOut.print("input month: ");
        int month = StdIn.readInt();
        StdOut.print("input day: ");
        int day = StdIn.readInt();
        SmartDate date = new SmartDate(year, month, day);
        StdOut.println(date);
    }

    private void validate(int y, int m, int d) {
        if (y < 0)
            throw new IllegalArgumentException("Illegal year input");
        if (m < 0 || m > 12)
            throw new IllegalArgumentException("Illegal month input");
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                if (d < 0 || d > 31)
                    throw new IllegalArgumentException("Illegal day");
            }
            case 2: {
                if (y % 4 == 0 && (d < 0 || d > 29))
                    throw new IllegalArgumentException("Illegal day");
                else if (y % 4 != 0 && (d < 0 || d > 28))
                    throw new IllegalArgumentException("Illegal day");
            }
            default: {
                if (d < 0 || d > 30)
                    throw new IllegalArgumentException("Illegal day");
            }
        }
    }

    public String toString() {
        return year + "-" + String.format("%02d", month) + "-" + day; //Using %02 to print number with padding 0
    }
}
