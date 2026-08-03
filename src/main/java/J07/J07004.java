package J07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class J07004 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));

        Map<Integer, Integer> mp = new TreeMap<>();

        while (sc.hasNext()){
            mp.merge(sc.nextInt(), 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()){
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }
    }
}
