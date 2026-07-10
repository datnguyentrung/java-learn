package J03;

import java.util.*;

public class J03020 {
    public static boolean checkS(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> mp = new LinkedHashMap<>();
        int maxLen = 0;

        while (sc.hasNext()) {
            String s = sc.next();

            if (checkS(s)) {
                mp.put(s, mp.getOrDefault(s, 0) + 1);
                maxLen = Math.max(maxLen, s.length());
            }
        }

        for (Map.Entry<String, Integer> e : mp.entrySet()) {
            if (e.getKey().length() == maxLen) {
                System.out.println(e.getKey() + " " + e.getValue());
            }
        }

        sc.close();
    }
}
