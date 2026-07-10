package J02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J02033 { // ĐẢO DẤU
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt();
        long sum = 0;
        List<Integer> duong = new ArrayList<>();
        List<Integer> am = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            sum += x;
            if (x < 0) am.add(x);
            else duong.add(x);
        }

        am.sort((a, b) -> a - b);

        for (int i = 0; i < am.size() && i < k; i++) {
            sum -= 2L * am.get(i);
            duong.add(-am.get(i));
        }

        int conLai = k - am.size();
        if (conLai % 2 != 0 && conLai > 0) {
            duong.sort((a, b) -> a - b);
            sum -= 2L * duong.get(0);
        }

        System.out.println(sum);
    }
}