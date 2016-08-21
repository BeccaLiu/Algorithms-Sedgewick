import edu.princeton.cs.algs4.In;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ex_1_1_28 {
    public static void main(String[] args) {
        int[] whitelist = new In(new File("tinyT.txt")).readAllInts();
        Arrays.sort(whitelist);
        removeDuplicate1(whitelist);
        removeDuplicate2(whitelist);
    }

    private static int[] removeDuplicate1(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1])
                count++;
        }
        int[] newWhitelist = new int[arr.length - count]; //if using arraylist, count and this step is not needed.
        int c = 0;
        newWhitelist[0] = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1])
                c++;
            else
                newWhitelist[i - c + 1] = arr[i + 1]; //count the duplicate c
        }
        return newWhitelist;
    }

    private static Integer[] removeDuplicate2(int[] arr) {
        //2nd
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1])
                list.add(arr[i + 1]);
        }
        Integer[] newList = list.toArray(new Integer[list.size()]);
        return newList;
    }
}