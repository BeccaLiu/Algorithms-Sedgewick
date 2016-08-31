import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#Sattolo.27s_algorithm

 */
public class WebExSattoloAlgorithm {
    public static void main(String[] args) {
        StdOut.print("Input N: ");
        int N = StdIn.readInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        for (int i = N - 1; i >= 1; i--) {
            int j = (int) (Math.random() * i); //Math.random() return double between [0,1)
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for (int k = 0; k < N; k++) {
            StdOut.print(arr[k] + " ");
        }
        StdOut.println();
    }
}