package J08;

import java.util.Scanner;
import java.util.Stack;

public class J08023 {
    static long ketqua(int[] a, int n) {
        Stack<Integer> st = new Stack<>();
        long res = 0;
        for (int i = 0; i <= n; i++) {
            long chieuCaoHienTai = (i==n) ? 0 : a[i];

            while (!st.isEmpty() && a[st.peek()] >= chieuCaoHienTai) {
                int vitri = st.pop();
                long chieuCao = a[vitri];

                int chieuRong;

                if (st.isEmpty()) {
                    chieuRong = i;
                } else {
                    chieuRong = i - st.peek() - 1;
                }

                res = Math.max(res, chieuCao*chieuRong);
            }

            if (i < n) st.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(ketqua(a, n));
        }
    }
}
