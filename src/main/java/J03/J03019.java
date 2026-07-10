package J03;

import java.util.Scanner;

public class J03019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        StringBuilder s = new StringBuilder();

        char maxC = 0;

        for (int i = line.length() - 1; i >= 0; i--) {
            char c = line.charAt(i);

            if (c >= maxC) {
                s.append(c);
                maxC = c;
            }
        }
        System.out.println(s.reverse());

        sc.close();
    }
}
