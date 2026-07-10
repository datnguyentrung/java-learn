package J02;

import java.util.Scanner;

public class J02023 { // LỰA CHỌN THAM LAM
    static int n, s;
    static int[] minA, maxA;

    static void maxN(){
        maxA = new int[n];
        int sum = s;
        for (int i = 0; i < n; i++){
            int digit = Math.min(9, sum);
            maxA[i] = digit;
            sum -= digit;
        }

        for (int i = 0; i < n; i++){
            System.out.print(maxA[i]);
        }
    }

    static void minN(){
        minA = new int[n];
        int sum = s - 1;
        for (int i = n-1; i >= 1; i--){
            int digit = Math.min(9, sum);
            minA[i] = digit;
            sum -= digit;
        }

        minA[0] = 1 + sum;

        for (int i = 0; i < n; i++) System.out.print(minA[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();

        if ((s == 0 && n > 1) || (s > n*9)){
            System.out.println("-1 -1");
        } else {
            minN();
            System.out.print(" ");
            maxN();
        }
    }
}