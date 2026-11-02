package J08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class J08022 {
    static void ketqua (int[] a) {
        int n = a.length;
        int[] res = new int[n];

        int[] st = new int[n];
        int top = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && st[top] <= a[i]) {
                top--;
            }

            res[i] = top < 0 ? -1 : st[top];
            st[++top] = a[i];
        }

        for (int x : res) System.out.print(x +" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            ketqua(a);
            System.out.println();
        }
    }
}
