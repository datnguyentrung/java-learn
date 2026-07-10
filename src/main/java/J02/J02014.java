package J02;

import java.util.Scanner;

public class J02014 { // ĐIỂM CÂN BẰNG

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] a = new int[n];
            long[] l = new long[n+1];
            l[0] = 0;
            long sum = 0;

            for (int i = 0; i < n; i++){
                a[i] = sc.nextInt();
                sum += a[i];
                l[i+1] = sum;
            }

            int ans = -1;
            boolean check = false;
            for (int i = 0; i < n && !check; i++){
                if (l[i] == sum - a[i] - l[i]) {
                    check = true;
                    ans = i+1;
                }
            }

            System.out.println(ans);
        }
    }
}
