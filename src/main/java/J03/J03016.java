package J03;

import java.math.BigInteger;
import java.util.Scanner;

public class J03016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            BigInteger n = sc.nextBigInteger();
            if (n.mod(BigInteger.valueOf(11)).equals(BigInteger.ZERO)) System.out.println(1);
            else System.out.println(0);
        }

        sc.close();
    }
}
