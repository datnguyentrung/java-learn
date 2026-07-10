package J02;

import java.util.Scanner;

public class J02021 { // LIỆT KÊ TỔ HỢP - 2
    static int n, k;
    static int[] a;
    static int count = 0;

    static void in() {
        for (int i = 1; i <= k; i++) {
            System.out.print(a[i]);
        }
        System.out.print(" ");
        count++;
    }

    static boolean sinh() {
        int i = k;

        while (i >= 1 && a[i] == n - k + i) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        a[i]++;

        for (int j = i + 1; j <= k; j++) {
            a[j] = a[j - 1] + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        a = new int[k + 1];

        for (int i = 1; i <= k; i++) {
            a[i] = i;
        }

        do {
            in();
        } while (sinh());
        System.out.println();
        System.out.println("Tong cong co " + count + " to hop");
    }
}