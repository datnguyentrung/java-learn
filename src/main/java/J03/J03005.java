package J03;

import java.util.Scanner;

public class J03005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0){
            String line = sc.nextLine();
            String[] splitLine = line.trim().split("\\s+");

            StringBuilder res = new StringBuilder();

            boolean first = true;
            for (String s : splitLine){
                if (first) {
                    first = false;
                    continue;
                }

                s = s.toLowerCase();
                res.append(Character.toUpperCase(s.charAt(0)))
                        .append(s.substring(1))
                        .append(" ");
            }

            res.deleteCharAt(res.length()-1).append(", ");

            res.append(splitLine[0].toUpperCase());

            System.out.println(res);
        }
    }
}
