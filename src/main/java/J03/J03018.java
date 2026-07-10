package J03;

import java.math.BigInteger;
import java.util.Scanner;

public class J03018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        BigInteger MOD = BigInteger.valueOf(5);

        while(t-- > 0){
            BigInteger n = sc.nextBigInteger();

            BigInteger ans = BigInteger.ZERO;

            ans = ans.add(BigInteger.ONE.modPow(n, MOD));

            ans = ans.add(BigInteger.valueOf(2).modPow(n, MOD));
            ans = ans.add(BigInteger.valueOf(3).modPow(n, MOD));
            ans = ans.add(BigInteger.valueOf(4).modPow(n, MOD));

            ans = ans.mod(MOD);

            System.out.println(ans);
        }

        sc.close();
    }
}
