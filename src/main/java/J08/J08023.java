package J08;

import java.util.Scanner;
import java.util.Stack;

public class J08023 {
    static void ketqua (int[] a) {
        int n = a.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= a[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }

            st.push(a[i]);
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
