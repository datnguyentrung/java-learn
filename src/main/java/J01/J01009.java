package J01;

import java.math.BigInteger;
import java.util.Scanner;

public class J01009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        BigInteger res = BigInteger.ZERO;

        for (int i = 1; i <= n; i++){
            BigInteger ans = BigInteger.ONE;
            for (int j = 1; j <= i; j++){
                ans = ans.multiply(BigInteger.valueOf(j));
            }
            res = res.add(ans);
        }

        System.out.println(res);
    }
}
