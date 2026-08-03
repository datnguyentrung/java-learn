package J07;

import java.io.*;
import java.util.*;

public class J07007 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));

        Set<String> set = new TreeSet<>();

        while (sc.hasNext()){
            String s = sc.next().toLowerCase();
            set.add(s);
        }

        for (String s : set) System.out.println(s);
    }
}
