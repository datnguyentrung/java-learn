package J03;

import java.util.Scanner;

public class J03007 {
    public static boolean checkN (String line){
        int n = line.length();
        long sum = 0;
        for (int i = 0; i < n/2; i++){
            if (line.charAt(i) != line.charAt(n-i-1)) return false;
        }

        if (line.charAt(0) != '8' || line.charAt(n-1) != '8') return false;

        for (int i = 0; i < n; i++){
            sum += line.charAt(i) - '0';
        }
        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0){
            String line = sc.nextLine();
            if (checkN(line)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
