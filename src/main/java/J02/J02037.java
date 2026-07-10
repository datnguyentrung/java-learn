package J02;

import java.util.Scanner;

public class J02037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= t; i++) {
            String line = sc.nextLine();
            String[] arr = line.trim().split("\\s+");
            int chan = 0, le = 0;

            for (String s : arr){
                int x = Integer.parseInt(s);

                if (x % 2 == 0) chan++;
                else le++;
            }
            int cnt = arr.length;

            if ((cnt % 2 == 0 && chan > le) || (cnt % 2 == 1 && le > chan)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
