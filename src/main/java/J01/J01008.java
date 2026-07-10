package J01;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class J01008 {
    static boolean checkN(long n){
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++){
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int cnt = 1;
        while (t-->0){
            long n = sc.nextLong();

            Map<Long, Long> mp = new TreeMap<>();
            long i = 2;
            while (n > 1){
                while (n % i == 0){
                    mp.merge(i, 1L, Long::sum);
                    n /= i;
                }
                i++;
            }

            StringBuilder s = new StringBuilder("Test " + cnt++ + ": ");
            for (Map.Entry<Long, Long> entry : mp.entrySet()){
                s.append(entry.getKey()).append("(").append(entry.getValue()).append(") ");
            }
            s.deleteCharAt(s.length()-1);
            System.out.println(s);
        }
    }
}
