package J02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class J02025 { // DÃY CON CÓ TỔNG NGUYÊN TỐ
    static int n;
    static Integer[] a;
    static ArrayList<ArrayList<Integer>> res;
    static ArrayList<Integer> current;

    static boolean check(){
        long sum = 0;
        for (int x : current) sum += x;
        if (sum < 2) return false;
        for (long i = 2; i * i <= sum; i++){
            if (sum % i == 0) return false;
        }
        return true;
    }

    static void Try (int index, int sum){
        if (index == n){
            if (!current.isEmpty() && check()){
                res.add( new ArrayList<>(current));
            }
            return;
        }

        // Chon
        current.add(a[index]);
        Try(index + 1, sum+a[index]);

        // Khong chon
        current.remove(current.size() - 1);
        Try(index + 1, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-->0){
            n = sc.nextInt();
            a = new Integer[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Arrays.sort(a, Collections.reverseOrder());

            res = new ArrayList<>();
            current = new ArrayList<>();

            Try(0, 0);

            Collections.sort(res, (x, y) -> {
                int len = Math.min(x.size(), y.size());

                for (int i = 0; i < len; i++){
                    if (!x.get(i).equals(y.get(i))){
                        return x.get(i) - y.get(i);
                    }
                }
                return x.size() - y.size();
            });

            for (ArrayList<Integer> arr : res) {
                StringBuilder sb = new StringBuilder();
                for (int x : arr) {
                    sb.append(x).append(" ");
                }
                System.out.println(sb.toString().trim());
            }
        }
    }
}