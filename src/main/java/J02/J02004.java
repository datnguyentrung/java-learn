package J02;

import java.util.Scanner;

public class J02004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            long[] arr = new long[ n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextLong();
            }

            boolean check = true;

            for (int i = 0; i < n/2; i++){
                if (arr[i] != arr[n-1-i]) {
                    check = false;
                    break;
                }
            }

            if (check) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
