import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

public class Wget {
    public static void main(String[] args) {
        String url = args[0];
        In in = new In(url);
        String data = in.readAll();

        String fileName = url.substring(url.lastIndexOf("/") + 1);
        Out out = new Out(fileName);
        out.print(data);
        out.close();
    }
}