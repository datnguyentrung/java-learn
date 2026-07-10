package J01;

import java.util.Scanner;

public class J01006 {
    static boolean checkN(long n){
        if (n < 2) return false;

        for (long i = 2; i * i <= n; i++){
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long fibo[] = new long[93];

        fibo[1] = 1;
        fibo[2] = 1;

        for (int i = 3; i <= 92; i ++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();

            System.out.println(fibo[n]);
        }
    }
}
