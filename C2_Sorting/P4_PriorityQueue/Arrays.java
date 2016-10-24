package P4_PriorityQueue;

/**
 * Created by rliu on 10/23/16.
 * Shared Array function
 */
public class Arrays {
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sink(Comparable[] a, int N, int k) {
        //int N = pq.length;
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(a[j], a[j + 1])) j++;
            if (!less(a[k], a[j])) break;
            exch(a, k, j);
            k = j;
        }
    }

    public static void swim(Comparable[] a, int k) {
        while (k > 1 && less(a[k / 2], a[k])) {
            exch(a, k, k / 2);
            k = k / 2;
        }
    }

    public static Comparable[] resize(Comparable[] a, int size) {
        Comparable[] b = new Comparable[size];
        for (int i = 0; i < a.length && i < size; i++) {
            b[i] = a[i];
        }
        return b;
    }
}
