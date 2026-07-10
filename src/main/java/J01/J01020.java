package J01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J01020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++){
            int x = sc.nextInt();

            if (x == 0){
                System.out.println("Impossible");
                continue;
            }

            Set<Character> s = new HashSet<>();

            int cnt = 1;
            int cur = 0;
            while (s.size() < 10){
                cur = x * cnt;
                for (char c : String.valueOf(cur).toCharArray()){
                    s.add(c);
                }
                cnt++;

            }

            System.out.println(cur);
        }
    }
}
