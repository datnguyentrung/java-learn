package J01;

import java.util.Scanner;

public class J01010 {
    static char catDoi(char c){
        switch (c){
            case '0': return '0';
            case '1': return '1';
            case '8': return '0';
            case '9': return '0';
            default: return '3';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-->0){
            String line = sc.nextLine();
            StringBuilder res = new StringBuilder();
            boolean check = true;
            for (char c : line.toCharArray()){
                char temp = catDoi(c);
                if (temp == '3') {
                    System.out.println("INVALID");
                    check = false;
                    break;
                }

                res.append(temp);
            }

            if (check){
                long ans = Long.parseLong(res.toString());
                if (ans == 0) System.out.println("INVALID");
                else System.out.println(ans);
            }
        }

    }
}
