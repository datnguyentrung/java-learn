package J03;

import java.math.BigInteger;
import java.util.Scanner;

public class J03040 {
    static boolean checkS(String s){
        s = s.substring(0, 3) + s.substring(4);
        boolean c1 = true, c2 = true, c3 = false, c4 = true;
        for (int i = 0; i < 5; i++){
            if (c1 && i > 0 && s.charAt(i-1) >= s.charAt(i)) c1 = false;
            if (c2 && i > 0 && s.charAt(i) != s.charAt(i-1)) c2 = false;
            if (c4 && s.charAt(i) != '6' && s.charAt(i) != '8') c4 = false;
        }
        if (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2)
            && s.charAt(3) == s.charAt(4)) c3 = true;

        return c1 || c2 || c3 || c4;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String line = sc.nextLine();

            if (checkS(line.substring(5))) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}