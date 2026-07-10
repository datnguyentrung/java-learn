package J02;

import java.util.Scanner;

public class J02101 { // IN MA TRẬN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-->0){
            int n = sc.nextInt();
            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    a[i][j] = sc.nextInt();
                }
            }

            boolean doiHuong = true;
            for (int i = 0; i < n; i++){
                if (doiHuong){
                    for (int j = 0; j < n; j++) System.out.print(a[i][j] + " ");
                    doiHuong = false;
                } else {
                    for (int j = n-1; j >= 0; j--) System.out.print(a[i][j] + " ");
                    doiHuong = true;
                }
            }
            System.out.println();
        }
    }
}
