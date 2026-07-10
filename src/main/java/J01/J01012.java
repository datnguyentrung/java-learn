package J01;

import java.util.Scanner;

public class J01012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-->0){
            long n = sc.nextLong();
            if (n % 2 != 0){
                System.out.println(0);
                continue;
            }

            n /= 2;

            int cnt = 0;
            for (int i = 1; i <= n/i; i++){
                if (n % i == 0){
                    if (i == n / i){
                        cnt ++;
                    } else cnt += 2;
                }
            }
            System.out.println(cnt);
        }

    }
}
