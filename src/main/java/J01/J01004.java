package J01;

import java.util.Scanner;

public class J01004 {
    static boolean checkN(long n){
        if (n < 2) return false;

        for (long i = 2; i * i <= n; i++){
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-->0){
            if (checkN(sc.nextLong())) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
