package J04;

import java.math.BigInteger;
import java.util.Scanner;

public class J04003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();

        BigInteger c = a.gcd(b);

        System.out.println(a.divide(c) + "/" + b.divide(c));
    }
}
