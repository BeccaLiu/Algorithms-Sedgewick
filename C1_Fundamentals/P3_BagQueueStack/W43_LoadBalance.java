package P3_BagQueueStack;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by rliu on 9/18/16.
 */
public class W43_LoadBalance {
    private Queue<String> users = new Queue<String>();
    private int load;

    public static void main(String[] args) {
        int n = 10; //there will be 10 server

        W43_LoadBalance[] servers = new W43_LoadBalance[n];
        for (int i = 0; i < n; i++)
            servers[i] = new W43_LoadBalance();

        //43
        for (int i = 0; i < 2 * n; i++) {
            String user = "User" + i;
            int j = StdRandom.uniform(n);
            servers[j].add(user);
        }
        for (int i = 0; i < n; i++)
            StdOut.println(i + ": " + servers[i]);

        //44 load balancing reload
        for (int i = 0; i < n; i++)
            servers[i] = new W43_LoadBalance();

        for (int i = 0; i < 2 * n; i++) {
            String user = "User" + i;
            int j = StdRandom.uniform(n);
            int k = StdRandom.uniform(n);
            if (servers[j].size() > servers[k].size())
                servers[k].add(user);
            else
                servers[j].add(user);
        }

        for (int i = 0; i < n; i++)
            StdOut.println(i + ": " + servers[i]);

    }

    public void add(String user) {
        users.enqueue(user);
        load++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String user : users) {
            sb.append(user + " ");
        }
        return sb.toString();
    }

    public int size() {
        return users.size();
    }
}
