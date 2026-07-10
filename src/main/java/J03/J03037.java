package J03;

import java.util.*;

public class J03037 {
    static boolean cross(int a1, int a2, int b1, int b2) {
        return (a1 < b1 && b1 < a2 && a2 < b2)
                || (b1 < a1 && a1 < b2 && b2 < a2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();

        int[][] pos = new int[26][2];
        int[] cnt = new int[26];

        for (int i = 0; i < line.length(); i++) {
            int id = line.charAt(i) - 'A';
            pos[id][cnt[id]++] = i;
        }

        int ans = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                if (cross(pos[i][0], pos[i][1], pos[j][0], pos[j][1])) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}