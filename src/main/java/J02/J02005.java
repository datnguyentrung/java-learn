package J02;

import java.util.*;

public class J02005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        Set<Integer> a = new TreeSet<>();
        Set<Integer> b = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            b.add(sc.nextInt());
        }

        a.retainAll(b);

        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}
