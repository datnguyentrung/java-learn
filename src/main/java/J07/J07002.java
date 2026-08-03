package J07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07002 {
    static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));

        long sum = 0;

        while (sc.hasNext()) {
            String s = sc.next();
            if (isInteger(s)){
                sum += Integer.parseInt(s);
            }
        }
        System.out.println(sum);
    }
}
