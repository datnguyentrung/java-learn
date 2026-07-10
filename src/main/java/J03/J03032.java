package J03;

import java.util.Scanner;

public class J03032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0){
            String line = sc.nextLine();

            String[] list = line.trim().split("\\s+");
            StringBuilder res = new StringBuilder();

            for (String s : list){
                StringBuilder sb = new StringBuilder(s);
                sb.reverse();
                res.append(sb).append(" ");
            }

            res.deleteCharAt(res.length()-1);

            System.out.println(res);
        }
    }
}
