package J02;

import java.util.Arrays;
import java.util.Scanner;

public class J02102 { // MA TRẬN XOẮN ỐC TĂNG DẦN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int[] temp = new int[n*n];

        for (int i = 0; i < n*n; i++) temp[i] = sc.nextInt();
        Arrays.sort(temp);

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int value = 0;

        while (top <= bottom && left <= right) {

            // Đi từ trái sang phải
            for (int j = left; j <= right; j++) {
                a[top][j] = temp[value++];
            }
            top++;

            // Đi từ trên xuống dưới
            for (int i = top; i <= bottom; i++) {
                a[i][right] = temp[value++];
            }
            right--;

            // Đi từ phải sang trái
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    a[bottom][j] = temp[value++];
                }
                bottom--;
            }

            // Đi từ dưới lên trên
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    a[i][left] = temp[value++];
                }
                left++;
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
