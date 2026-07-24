package J02;


import java.util.Scanner;

public class J02106 { // DANH SÁCH CẠNH
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cnt1 = 0;
            for (int j = 0; j < 3; j++) {
                if (sc.nextInt() == 1) cnt1 ++;
            }
            res += cnt1 > 1 ? 1 : 0;
        }

        System.out.println(res);
    }
}
