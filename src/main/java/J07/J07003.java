package J07;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class J07003 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));

        String sum = sc.nextLine().trim();

        while (sum.length() != 1) {
            int n = sum.length()/2;
            String st = sum.substring(0, n);
            String en = sum.substring(n);

            BigInteger res = new BigInteger(st)
                    .add(new BigInteger(en));
            sum = res.toString();

            System.out.println(sum);
        }

    }
}
