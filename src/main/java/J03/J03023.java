package J03;

import java.util.Scanner;

public class J03023 {
    static int value(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        return 1000; // M
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String line = sc.nextLine();
            int res = 0;
            for (int i = 0; i < line.length(); i++) {
                if (i+1 < line.length() && value(line.charAt(i)) < value(line.charAt(i + 1))){
                    res -= value(line.charAt(i));
                } else {
                    res += value(line.charAt(i));
                }
            }

            System.out.println(res);
        }

        sc.close();
    }
}
