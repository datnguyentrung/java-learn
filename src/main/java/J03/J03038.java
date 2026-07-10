package J03;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J03038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();

        Set<Character> set = new HashSet<>();
        for (char c : line.toCharArray()){
            set.add(c);
        }

        System.out.println(set.size());
    }
}