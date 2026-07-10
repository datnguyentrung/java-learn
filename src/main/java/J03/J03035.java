package J03;

import java.util.Scanner;

public class J03035 {
    static long b;
    static long count;

    static void Try(char[] a, int i){
        if (i == a.length){
            long x = Long.parseLong(new String(a));
            if (x > b) count++;
            return;
        }

        if (a[i] != '?'){
            Try(a, i+1);
        } else {
            for (char c = '0'; c <= '9'; c++){
                a[i] = c;
                Try(a, i+1);
            }
            a[i] = '?';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0){
            String s1 = sc.next();
            String s2 = sc.next();

            b = Long.parseLong(s2);
            count = 0;

            Try(s1.toCharArray(), 0);

            System.out.println(count);
        }
    }
}
