package J03;

import java.util.Scanner;

public class J03025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String line = sc.nextLine();

            int cnt = 0;
            boolean res = true;
            for (int i = 0; i < line.length()/2; i++){
                if (line.charAt(i) != line.charAt(line.length()-1-i)){
                    cnt++;
                    if (cnt > 1){
                        res = false;
                        break;
                    }
                }
            }

            if (cnt == 0 && line.length() % 2 == 0) res = false;

            if (res) System.out.println("YES");
            else System.out.println("NO");
        }

        sc.close();
    }
}
