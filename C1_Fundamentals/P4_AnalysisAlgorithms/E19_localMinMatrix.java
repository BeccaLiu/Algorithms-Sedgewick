package P4_AnalysisAlgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 9/28/16.
 */
public class E19_localMinMatrix {
    public static void main(String[] args) {
        int[][] a = generateArray(20);
        for (int i = 1; i < a.length - 1; i++) {
            int low = 0;
            int high = a.length;
            int index = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (a[i][mid] < a[i][mid - 1] && a[i][mid] < a[i][mid + 1]) {
                    if (a[i][mid] < a[i - 1][mid] && a[i][mid] < a[i + 1][mid]) {
                        index = mid;
                        break;
                    }
                } else if (a[i][mid - 1] < a[i][mid] && a[i][mid] < a[i][mid + 1])
                    high = mid - 1;
                else if (a[i][mid - 1] > a[i][mid] && a[i][mid] > a[i][mid + 1])
                    low = mid + 1;
            }
            if (index != -1) {
                StdOut.println(String.format("%4s%4d%4s", "", a[i - 1][index], ""));
                StdOut.println(String.format("%4d%4d%4d", a[i][index - 1], a[i][index], a[i][index + 1]));
                StdOut.println(String.format("%4s%4d%4s", "", a[i + 1][index], ""));
                break;
            }
        }
    }

    public static int[][] generateArray(int size) {
        int[][] a = new int[size][size];
        int inc = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                a[i][j] = inc++;

        //shuffle the matrix
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                int index = StdRandom.uniform(i * size + j, size * size);
                int temp = a[i][j];
                int row = index / size;
                int col = index % size;
                a[i][j] = a[row][col];
                a[row][col] = temp;
            }
        return a;
    }
}
