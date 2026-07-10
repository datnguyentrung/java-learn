package J03;

import java.util.Scanner;

public class J03007 {
    public static boolean checkN (String line){
        int n = line.length();
        for (int i = 0; i < n/2; i++){
            if (line.charAt(i) != line.charAt(n-1-i)
                    || (line.charAt(i)) == '1'
                    || (line.charAt(i)) == '4'
                    || (line.charAt(i)) == '6'
                    || (line.charAt(i)) == '8'
                    || (line.charAt(i)) == '9'
            ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0){
            String line = sc.nextLine();
            if (checkN(line)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
