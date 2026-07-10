package J01;

import java.math.BigInteger;
import java.util.Scanner;

public class J01011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-->0){
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();

            BigInteger c = a.gcd(b);
            BigInteger d = a.multiply(b).divide(c);

            System.out.println(d + " " + c);
        }

    }
}
