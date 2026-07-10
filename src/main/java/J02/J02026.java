package J02;

import java.util.Arrays;
import java.util.Scanner;

public class J02026 { // DÃY CON CÓ K PHẦN TỬ TĂNG DẦN
    static int n, k;
    static int[] a;
    static int[] c;

    static void in() {
        for (int i = 1; i <= k; i++) System.out.print(a[c[i]] + " ");
        System.out.println();
    }

    static void Try(int i){
        for (int j = c[i - 1] + 1; j <= n-k+i; j++){
            c[i] = j;

            if (i == k){
                in();
            } else {
                Try(i+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0 ){
            n = sc.nextInt();
            k = sc.nextInt();

            a = new int[n + 1];
            c = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a, 1, n+1);

            c[0] = 0;
            Try(1);
        }


    }
}