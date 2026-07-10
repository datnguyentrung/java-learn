package J03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J03028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        Map<Character, Integer> mpS = new HashMap<>();
        Map<Integer, Character> mpN = new HashMap<>();

        for (int i = 0, c = 'A'; i <= 25; i++, c++){
            mpN.put(i, (char) c);
            mpS.put((char) c, i);
        }

        while(t-- > 0){
            String line = sc.nextLine();

            // --- Phase 1: Chia
            String c1 = line.substring(0, line.length()/2);
            String c2 = line.substring(line.length()/2);

            // --- Phase 2: Xoay
            // -- Nua dau
            int sum1 = 0;
            for (char c : c1.toCharArray()){
                sum1 += mpS.get(c);
            }

            StringBuilder newC1 = new StringBuilder();
            for (char c : c1.toCharArray()){
                newC1.append(mpN.get((mpS.get(c) + sum1) % 26));
            }

            // -- Nua sau
            int sum2 = 0;
            for (char c : c2.toCharArray()){
                sum2 += mpS.get(c);
            }

            StringBuilder newC2 = new StringBuilder();
            for (char c : c2.toCharArray()){
                newC2.append(mpN.get((mpS.get(c) + sum2) % 26));
            }

            // --- Phase 3: Merge
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < newC1.length(); i++){
                res.append(
                        mpN.get(
                                (mpS.get(newC1.charAt(i)) + mpS.get(newC2.charAt(i))) % 26
                        )
                );
            }

            System.out.println(res);
        }
    }
}
