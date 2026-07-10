package J03;

import java.util.*;

public class J03031 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0){
            String line = sc.nextLine();
            int n = sc.nextInt();
            Map<Character, Integer> mp = new HashMap<>();

            for (char c : line.toCharArray()){
                mp.merge(c, 1, Integer::sum);
            }

            int cnt = 0, sum = 0;
            for (Map.Entry<Character, Integer> entry : mp.entrySet()){
                cnt++;
                sum += entry.getValue();
            }

            if (26-cnt > n || sum - cnt < 26-cnt) System.out.println("NO");
            else System.out.println("YES");

            sc.nextLine();
        }
    }
}
