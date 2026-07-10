package J01;

import java.util.Scanner;

public class J01007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-->0){
            long n = sc.nextLong();

            long n1 = 1, n2 = 1;

            if (n == 1 || n== 0) System.out.println("YES");
            else {
                while (n1 + n2 < n){
                    long temp = n1 + n2;
                    n1 = n2;
                    n2 = temp;
                }

                if (n1 + n2 == n) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
