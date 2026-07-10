package J08012;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J08012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 1; i < n; i++){
            int a = sc.nextInt(), b = sc.nextInt();

            mp.putIfAbsent(a, 0);
            mp.putIfAbsent(b, 0);

            mp.merge(a, 1, Integer::sum);
            mp.merge(b, 1, Integer::sum);
        }

        int dinhSao = 0, dinhCanh = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if (entry.getValue() == n - 1) {
                dinhSao += 1;
            } else if (entry.getValue() == 1) {
                dinhCanh += 1;
            }
        }

        if (dinhSao == 1 && dinhCanh == n-1) System.out.print("Yes");
        else System.out.print("No");
    }
}
