package J07;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class J07006 {
    public static void main(String[] args)
            throws IOException, ClassNotFoundException {

        ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("DATA.in")
        );

        ArrayList<Integer> list =
                (ArrayList<Integer>) input.readObject();

        int[] count = new int[1000];

        for (int x : list) {
            count[x]++;
        }

        for (int i = 0; i < 1000; i++) {
            if (count[i] > 0) {
                System.out.println(i + " " + count[i]);
            }
        }

        input.close();
    }
}
