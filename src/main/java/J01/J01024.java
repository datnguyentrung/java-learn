package J01;

import java.util.Scanner;

public class J01024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-->0) {
            String line = sc.nextLine();
            boolean check = true;
            for (char c : line.toCharArray()){
                if (c != '0' && c != '1' && c != '2') {
                    check = false;
                    break;
                }
            }

            if (check) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
