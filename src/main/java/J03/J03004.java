package J03;

import java.util.Scanner;

public class J03004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();

            String[] splitList = line.trim().split("\\s+");
            StringBuilder res = new StringBuilder();

            for (String s : splitList) {
                s = s.toLowerCase();
                res.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).append(" ");
            }

            res.deleteCharAt(res.length() - 1);

            System.out.println(res);
        }
    }
}
