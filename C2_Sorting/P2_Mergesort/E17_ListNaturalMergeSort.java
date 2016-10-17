package P2_Mergesort;

/**
 * Created by rliu on 10/16/16.
 * haven't figured out yet, will modify this in the future.
 */
public class E17_ListNaturalMergeSort {
    public static void main(String[] args) {
        Node head = new Node();
        int size = 50;
//        Node temp = head;
//        for (int i = 0; i < size; i++) {
//            temp.next = new Node(StdRandom.uniform(100));
//            temp = temp.next;
//        }

        Node l3 = new Node(3);
        Node mid = l3.next = new Node(10);
        l3.next.next = new Node(0);
        l3.next.next.next = new Node(5);
        Node hi = l3.next.next.next.next = new Node(9);
        Node af = merge(l3, mid, hi);
        sort(head.next);


    }

    public static Node sort(Node head) {
        Node temp = head;
        while (!isSorted(head.next)) {
            Node lo = temp;
            while (temp.next != null && temp.compareTo(temp.next) < 0)
                temp = temp.next;
            Node mid = temp;
            temp = temp.next;
            while (temp.next != null && temp.compareTo(temp.next) < 0)
                temp = temp.next;
            Node hi = temp;
            temp = temp.next;
            lo = merge(lo, mid, hi);
        }
        return temp;
    }

    public static boolean isSorted(Node head) {
        while (head.next != null) {
            if (head.compareTo(head.next) > 0)
                return false;
        }
        return true;
    }

    public static Node merge(Node lo, Node mid, Node hi) {
        Node head = new Node();
        Node temp = head;
        Node first = lo;
        Node second = mid.next;
        mid.next = null;

        while (true) {
            if (first == null) {
                temp.next = second;
                break;
            } else if (second == hi.next) {
                while (first != null) {
                    temp.next = first;
                    first = first.next;
                    temp = temp.next;
                }
                temp = hi.next;
                break;
            } else if (first.compareTo(second) < 0) {
                temp.next = first;
                first = first.next;
                temp = temp.next;
            } else {
                temp.next = second;
                second = second.next;
                temp = temp.next;
            }
        }
        return head.next;

    }

    private static class Node implements Comparable<Node> {
        int val;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }

        public int compareTo(Node n) {
            return this.val - n.val;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node temp = this;
            while (temp != null) {
                sb.append(temp.val + " ");
                temp = temp.next;
            }
            return sb.toString();
        }
    }
}
