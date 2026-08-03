package J08;

import java.util.*;

public class J08015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 1; i <= t; i++){
            int n = sc.nextInt(), k = sc.nextInt();

            long count = 0;
            Map<Integer, Integer> mp = new HashMap<>();

            for (int j = 1; j <= n; j++){
                int x = sc.nextInt();

                int need = k - x;

                count += mp.getOrDefault(need, 0);

                mp.merge(x, 1, Integer::sum);
            }

            System.out.println(count);
        }
    }
}
