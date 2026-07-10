package J02;

import java.math.BigInteger;
import java.util.Scanner;

public class J02008 {
    static BigInteger lcm (BigInteger a, BigInteger b){
        return a.divide(a.gcd(b)).multiply(b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-->0){
            BigInteger[] dp = new BigInteger[101];
            int n = sc.nextInt();

            dp[1] = BigInteger.ONE;
            for (int i = 2; i <= n; i++){
                dp[i] = lcm(dp[i-1], BigInteger.valueOf(i));
            }

            System.out.println(dp[n]);
        }
    }
}
