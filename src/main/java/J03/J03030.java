package J03;

import java.util.Scanner;

public class J03030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int dp0 = 0;
        int dp1 = 1_000_000_000;

        for (int i = s.length() - 1; i >= 0; i--) {
            int x = s.charAt(i) == 'B' ? 1 : 0;

            int newDp0 = Math.min(
                    dp0 + x,
                    dp1 + 1 + x
            );

            int newDp1 = Math.min(
                    dp1 + (x ^ 1),
                    dp0 + 1 + (x ^ 1)
            );

            dp0 = newDp0;
            dp1 = newDp1;
        }

        System.out.println(Math.min(dp0, dp1));
    }
}