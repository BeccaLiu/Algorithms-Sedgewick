import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
Write a code fragment to print the transposition (rows and columns changed) of a two-dimensional array with M rows and N columns
 */
public class ex_1_1_13 {
    public static void main(String args[]) {
        StdOut.print("Input Matrix Size:");
        int M = StdIn.readInt();
        int N = StdIn.readInt();
        int[][] originalMatrix = new int[M][N];
        generateMatrix(originalMatrix, 9);
        printMatrix(originalMatrix);
        int[][] newMatrix = transportation(originalMatrix);
        printMatrix(newMatrix);
    }

    public static int[][] transportation(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                StdOut.print(matrix[i][j] + " ");
            }
            StdOut.println();
        }
    }

    public static int[][] generateMatrix(int[][] matrix, int N) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = StdRandom.uniform(N);
            }
        }
        return matrix;
    }
}