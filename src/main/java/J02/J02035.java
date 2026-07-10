package J02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J02035 { // QUAY PHẢI
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            List<Long> a = new ArrayList<>();

            for (int i = 0; i < n; i++) a.add(sc.nextLong());

            long k = 0;
            for (int i = 1; i < n && k == 0; i++){
                if (a.get(i-1) > a.get(i)) k = i;
            }

            System.out.println(k);
        }
    }
}