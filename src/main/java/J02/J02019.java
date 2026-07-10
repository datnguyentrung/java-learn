package J02;

import java.util.Scanner;
import java.util.Stack;

public class J02019 { // TỔNG ƯỚC SỐ - 2

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt();

        int[] sumDiv = new int[b + 1];

        for (int i = 1; i <= b / 2; i++) {
            for (int j = i * 2; j <= b; j += i) {
                sumDiv[j] += i;
            }
        }

        int count = 0;

        for (int i = a; i <= b; i++) {
            if (sumDiv[i] > i) {
                count++;
            }
        }

        System.out.println(count);
    }
}