package J02;


import java.util.Scanner;

public class J02103 { // TÍCH MA TRẬN VỚI CHUYỂN VỊ CỦA NÓ
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int cnt = 1;
        while (t-->0){
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] a = new int[n][m];
            int[][] b = new int[m][n];

            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    a[i][j] = sc.nextInt();
                    b[j][i] = a[i][j];
                }
            }

            int[][] c = new int[n][n];

            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    int sum = 0;
                    for (int k = 0; k < m; k++){
                        sum += a[i][k] * b[k][j];
                    }
                    c[i][j] = sum;
                }
            }

            System.out.println("Test " + cnt++ + ":");
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
