package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;

import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rliu on 9/8/16.
 */
public class W19_Set implements Iterable {
    boolean[] arr;
    int N;
    private int size;

    public W19_Set(int N) {
        this.N = N;
        size = 0;
        arr = new boolean[N];
    }

    public W19_Set(int[] a, int N) {
        this.N = N;
        arr = new boolean[N];
        for (int i = 0; i < a.length; i++)
            this.add(a[i]);
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 7, 8, 9};
        int[] a2 = {1, 2, 4, 6, 8, 9};
        W19_Set a = new W19_Set(a1, 10);
        W19_Set b = new W19_Set(a2, 10);
        StdOut.println(a.union(b));
        StdOut.println(a.intersect(b));
        StdOut.println(a.difference(b));
        StdOut.println(a.symmetricDifference(b));
        W19_Set c = new W19_Set(10);
        c.add(a.remove(3));
        c.add(a.remove(5));
        c.add(a.remove(7));
        StdOut.println(a.isSubSet(b));
        StdOut.println(b.isSuperSet(a));
        StdOut.println(b.isDisjointFrom(c));
    }

    public void add(Integer i) {
        if (i >= arr.length)
            throw new InvalidParameterException("input is invalid");
        if (arr[i] == false)
            arr[i] = true;
        size++;
    }

    public Integer remove(Integer i) {
        if (i >= arr.length)
            throw new NoSuchElementException();
        size--;
        arr[i] = false;
        return i;
    }

    public boolean exist(Integer i) {
        return arr[i];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == true)
                sb.append(i).append(" ");
        }
        return sb.toString();
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public W19_Set intersect(W19_Set set2) {
        W19_Set rt = new W19_Set(N);
        int i = 0;
        for (Object o : set2) {
            if (arr[i] == true && (Boolean) o == true) {
                rt.add(i);
            }
            i++;
        }
        return rt;
    }

    public W19_Set difference(W19_Set set2) {
        W19_Set intersect = this.intersect(set2);
        W19_Set rt = new W19_Set(N);
        int i = 0;
        for (Object o : intersect) {
            if (arr[i] == true && (Boolean) o == false)
                rt.add(i);
            i++;
        }
        return rt;
    }

    public W19_Set symmetricDifference(W19_Set set2) {
        W19_Set intersect = this.intersect(set2);
        W19_Set union = this.union(set2);
        return union.difference(intersect);
    }

    public W19_Set union(W19_Set set2) {
        W19_Set rt = new W19_Set(N);
        int i = 0;
        for (Object o : set2) {
            if (arr[i] == true || (Boolean) o == true) {
                rt.add(i);
            }
            i++;
        }
        return rt;
    }

    public boolean isSubSet(W19_Set set2) {
        int i = 0;
        for (Object o : set2) {
            if (arr[i] == true && (Boolean) o != true)
                return false;
            i++;
        }
        return true;
    }

    public boolean isSuperSet(W19_Set set2) {
        int i = 0;
        for (Object o : set2) {
            if ((Boolean) o == true && arr[i] != true)
                return false;
            i++;
        }
        return true;
    }

    public boolean isDisjointFrom(W19_Set set2) {
        int i = 0;
        for (Object o : set2) {
            if ((Boolean) o == true && arr[i] == true)
                return false;
            i++;
        }
        return true;
    }

    public Iterator iterator() {
        return new setIterator();
    }

    private class setIterator implements Iterator {

        int index = 0;

        public boolean hasNext() {
            return index != arr.length;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Boolean next() {
            boolean curr = arr[index];
            index++;
            return curr;
        }
    }
}
