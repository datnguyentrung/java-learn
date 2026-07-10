package J03;

import java.util.Scanner;

public class J03026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();

            if (line1.equals(line2)) System.out.println(-1);
            else System.out.println(Math.max(line1.length(), line2.length()));
        }

        sc.close();
    }
}
