package P3_BagQueueStack;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by rliu on 9/12/16.
 */
public class W26_SongPlayList implements Iterable<String> {
    private Node pre;
    private Node post;
    private int size;

    public W26_SongPlayList() {
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
    }

    public static void main(String args[]) {
        W26_SongPlayList songPlayList = new W26_SongPlayList();
        String[] songList = {"you know my heart", "lonely rain", "without you", "black heart", "we will rock you"};
        for (String s : songList)
            songPlayList.enqueue(s);

        SongIterator si = songPlayList.iterator();
        while (si.hasNext()) {
            StdOut.println(si.play());
            si.skip();
        }
        while (si.hasPrevious()) {
            StdOut.println(si.play());
            si.back();
        }


    }

    public void enqueue(String s) {
        Node node = new Node();
        node.song = s;
        Node last = post.prev;
        last.next = node;
        node.next = post;
        post.prev = node;
        node.prev = last;
        size++;
    }

    public SongIterator<String> iterator() {
        return new SongIterator<String>() {
            Node curr = pre.next;
            int index = 0;

            @Override
            public boolean hasPrevious() {
                return index > 0;
            }

            @Override
            public void back() {
                curr = curr.prev;
                index--;
            }

            @Override
            public String play() {
                return curr.song;
            }

            @Override
            public void skip() {
                if (hasNext()) {
                    curr = curr.next;
                    index++;
                }
            }

            @Override
            public boolean hasNext() {
                return index < size - 1;
            }

            @Override
            public String next() {
                String s = curr.song;
                curr = curr.next;
                index++;
                return null;
            }
        };
    }


    interface SongIterator<String> extends Iterator<String> {
        boolean hasPrevious();

        String play();

        void skip();

        void back();
    }

    private class Node {
        String song;
        Node next;
        Node prev;
    }

}
