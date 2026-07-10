package J01;

import java.util.Scanner;

public class J01021 {
    static long MOD = 1000000007;

    static long tinh (long a, long b){
        long res = 1;
        a %= MOD;

        while (b > 0){
            if (b % 2 == 1){
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            long a = sc.nextLong(), b = sc.nextLong();
            if (a == 0 && b == 0) return;

            System.out.println(tinh(a, b));
        }
    }
}
