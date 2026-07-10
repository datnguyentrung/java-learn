package J02;

import java.util.Arrays;
import java.util.Scanner;

public class J02028 { // DÃY CON LIÊN TIẾP TỔNG BẰNG K
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0 ){
            int n = sc.nextInt();
            long k = sc.nextLong();

            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            int left = 0;
            boolean res = false;
            long sum = 0;

            for (int right = 0; right < n; right++){
                sum += a[right];

                while (sum > k && left <= right){
                    sum -= a[left];
                    left++;
                }

                if (sum == k && left <= right){
                    res = true;
                    break;
                }
            }

            if (res) System.out.println("YES");
            else System.out.println("NO");
        }


    }
}