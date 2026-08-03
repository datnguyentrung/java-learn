package test.T3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class B3 {
    static boolean checkN (int n) {
        if (n < 10) return false;

        int r = n%10;
        n/=10;

        while (n > 0){
            int l = n%10;
            if (l < r) return false;
            r = l;
            n /= 10;
        }

        return true;
    }

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {

        ObjectInputStream input1 = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("DATA1.in")
                )
        );

        ObjectInputStream input2 = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("DATA2.in")
                )
        );

        ArrayList<Integer> list1 =
                (ArrayList<Integer>) input1.readObject();

        ArrayList<Integer> list2 =
                (ArrayList<Integer>) input2.readObject();

        input1.close();
        input2.close();

        Map<Integer, Integer> l1 = new HashMap<>();
        Map<Integer, Integer> l2 = new HashMap<>();

        for (int x : list1) {
            if (checkN(x)){
                l1.merge(x, 1, Integer::sum);
            }
        }
        for (int x : list2) {
            if (checkN(x)) {
                l2.merge(x, 1, Integer::sum);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int val : l1.keySet()) {
            if (l2.containsKey(val)) res.add(val);
        }

        Collections.sort(res);

        StringBuilder output = new StringBuilder();

        for (int val : res) {
            output.append(val)
                    .append(' ')
                    .append(l1.get(val))
                    .append(' ')
                    .append(l2.get(val))
                    .append('\n');
        }
        System.out.println(output);
    }
}
