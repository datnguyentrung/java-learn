package J01;

import java.util.Scanner;

public class J01013 {
    static int MAX = 2000000;

    static int[] spf = new int[MAX + 1];

    static void sieve(){
        for (int i = 0; i <= MAX; i++){
            spf[i] = i;
        }

        for (int i = 2; i * i <= MAX; i++){
            if (spf[i] == i){
                for (int j = i * i; j <= MAX; j += i){
                    if (spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        long res = 0;
        sieve();

        while (t-->0){
            int n = sc.nextInt();
            int sum = 0;

            while (n > 1){
                sum += spf[n];
                n /= spf[n];
            }

            res += sum;
        }

        System.out.println(res);
    }
}
