package J03;

import java.util.Scanner;

public class J03011 {
    static long gcd(long a, long b){
        while (b != 0){
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long modBigNumber(String b, long a){
        long res = 0;
        for (int i = 0; i < b.length(); i++){
            res = (res * 10 + (b.charAt(i) - '0')) % a;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0){
            long a = sc.nextLong();
            sc.nextLine();

            String b = sc.nextLine();

            long rem = modBigNumber(b, a);

            System.out.println(gcd(a, rem));
        }
    }
}
