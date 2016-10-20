package P3_QuickSort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * Created by rliu on 10/19/16.
 * nlogn each layer need 2N compares, and has log N layer
 * the tricky part of this problem is :
 * first: you will skip over the items with same size of partition value, but remember the index
 * second: because of this there are so many conditions you need to consider in each layer
 * need exchange from s to d, and d is where item should be
 * 1:   [lo][][][][s][][][j/d][i][][][][][hi]     2:[lo][][][][s][][][][][][][][][s/j/i/hi]
 * 3:   [lo][][][][][][][j/d][i][][][][s][hi]     4:[lo/j/i/d][][][][][][][][][s][][][][hi]
 * 5:   [lo][][][][][][j][d/s][i][][][][][hi]
 * 6:   [lo/s/d/j][i][][][][][][][][][][][][hi]
 * 7:   [lo][][][][][][][][][][][][j][i/s/d/hi]
 */
public class NutsAndBolts {
    public static void main(String[] args) {
        int N = 25;
        Nut[] nuts = new Nut[N];
        Bolt[] bolts = new Bolt[N];
        IntStream.range(0, N).parallel().forEach(i -> {
            nuts[i] = new Nut(i);
            bolts[i] = new Bolt(i);
        });
        shuffle(nuts);
        shuffle(bolts);
        sort(nuts, bolts, 0, nuts.length - 1);
        StdOut.println();
        for (Nut n : nuts) {
            StdOut.print(n);
        }

        StdOut.println();
        for (Bolt n : bolts) {
            StdOut.print(n);
        }
    }

    public static int partition(Nut[] nuts, Bolt[] bolts, int lo, int hi) {
        int nutIndex = StdRandom.uniform(lo, hi + 1);
        int boltIndex = -1;
        int i = lo - 1;
        int j = hi + 1;
        int nutSize = nuts[nutIndex].size;
        while (true) {
            while (bolts[++i].size <= nutSize) {
                if (bolts[i].size == nutSize)
                    boltIndex = i;
                if (i >= hi)
                    break;
            }

            while (bolts[--j].size >= nutSize) {
                if (bolts[j].size == nutSize)
                    boltIndex = j;
                if (j <= lo)
                    break;
            }

            if (i >= j)
                break;

            exch(bolts, i, j);
        }

        if (boltIndex > j && boltIndex < i) { //boltIndex is already in the its position, but is in the middle of the array
            int n = partitionNuts(nuts, bolts, lo, hi, nutIndex, boltIndex);
            return boltIndex;
        } else if (boltIndex == j) { //boltIndex is already in its correct position, but ==lo, boltIndex=j=lo<i,j+1=i;
            exch(nuts, nutIndex, j);
            return j;
        } else if (boltIndex == i) { //boltIndex is already in its correct position, but ==hi, boltIndex=i=hi>j,j+1=i;
            exch(nuts, nutIndex, i);
            return i;
        } else if (boltIndex < j) { //boltIndex<j<i,j+1=i
            exch(bolts, boltIndex, j);
            int n = partitionNuts(nuts, bolts, lo, hi, nutIndex, j);
            return j;
        } else {//j<i<boltIndex, j+1=i
            exch(bolts, boltIndex, i);
            int n = partitionNuts(nuts, bolts, lo, hi, nutIndex, i);
            return i;
        }
    }


    public static int partitionNuts(Nut[] nuts, Bolt[] bolts, int lo, int hi, int nutIndex, int boltIndex) {
        int i = lo - 1;
        int j = hi + 1;
        int boltSize = bolts[boltIndex].size;
        while (true) {
            while (nuts[++i].size <= boltSize) {
                if (i >= hi)
                    break;
            }

            while (nuts[--j].size >= boltSize) {
                if (j <= lo)
                    break;
            }

            if (i >= j)
                break;

            exch(nuts, i, j);
        }

        if (nutIndex < j) {
            exch(nuts, nutIndex, j);
            return j;
        } else if (nutIndex > i) {
            exch(nuts, nutIndex, i);
            return i;
        } else {
            return nutIndex;
        }
    }

    public static void sort(Nut[] nuts, Bolt[] bolts, int lo, int hi) {
        if (lo >= hi)
            return;
        int p = partition(nuts, bolts, lo, hi);
        // StdOut.print(p+" ");
        sort(nuts, bolts, lo, p - 1);
        sort(nuts, bolts, p + 1, hi);
    }

    public static void exch(Object[] objects, int i, int j) {
        Object temp = objects[i];
        objects[i] = objects[j];
        objects[j] = temp;
    }

    public static void shuffle(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            int j = StdRandom.uniform(i, objects.length);
            exch(objects, i, j);
        }
    }

    private static class Nut {
        int size;

        public Nut(int size) {
            this.size = size;
        }

        public String toString() {
            return size + " ";
        }
    }

    private static class Bolt {
        int size;

        public Bolt(int size) {
            this.size = size;
        }

        public String toString() {
            return size + " ";
        }
    }
}
