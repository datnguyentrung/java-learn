package J01;

import java.util.Scanner;

public class J01026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0){
            long n = sc.nextLong();

            long i = (long) Math.sqrt(n);
            if (i * i == n) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}