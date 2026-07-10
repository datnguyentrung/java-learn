package J01;

import java.util.Scanner;

public class J01017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-->0){
            String line = sc.nextLine();
            boolean check = true;
            for (int i = 1; i < line.length(); i++){
                if (Math.abs((line.charAt(i) - '0') - ((line.charAt(i-1)) - '0')) != 1){
                    System.out.println("NO");
                    check = false;
                    break;
                }
            }
            if (check) System.out.println("YES");
        }
    }
}
