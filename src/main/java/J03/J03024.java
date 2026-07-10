package J03;

import java.util.Scanner;

public class J03024 {
    // 0: false
    // 1: true
    // 2: loi-invalid
    static int checkS(String s){
        int n = s.length();
        int chan = 0, le = 0;
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if (c < '0' || c > '9') return 2;
            else if ((c - '0') % 2 == 0) chan++;
            else le++;
        }

        if (n % 2 == 0 && chan > le) return 1;
        else if (n % 2 != 0 && le > chan) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String line = sc.nextLine();

            if (checkS(line) == 0) System.out.println("NO");
            else if (checkS(line) == 1) {
                System.out.println("YES");
            } else {
                System.out.println("INVALID");
            }
        }

        sc.close();
    }
}
