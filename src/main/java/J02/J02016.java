package J02;

import java.util.Arrays;
import java.util.Scanner;

public class J02016 { // BỘ BA SỐ PYTAGO

    static boolean check(long[] a) {
        int n = a.length;

        Arrays.sort(a);

        for (int i = n - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;

            while (l < r) {
                long sum = a[l] + a[r];

                if (sum == a[i]) {
                    return true;
                } else if (sum > a[i]) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                long x = sc.nextLong();
                a[i] = x * x;
            }

            System.out.println(check(a) ? "YES" : "NO");
        }
    }
}