package J01;

import java.util.Scanner;

public class J01022 {
    static long[] len = new long[94];

    static void sieve(){
        len[1] = 1;
        len[2] = 1;

        for (int i = 3; i <= 93; i++){
            len[i] = len[i - 2] + len[i - 1];
        }
    }

    static char find(int n, long k){
        while (n > 2){
            if (k <= len[n-2]){
                n = n-2;
            } else {
                k -= len[n-2];
                n = n-1;
            }
        }
        if (n == 1) return '0';
        else return '1';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sieve();
        while (t-->0) {
            int n = sc.nextInt();
            long k = sc.nextLong();

            System.out.println(find(n, k));
        }
    }
}
