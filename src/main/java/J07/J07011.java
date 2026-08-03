package J07;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class J07011 {
    static class Tu {
        String tu;
        int cnt;

        public Tu(String tu, int cnt) {
            this.tu = tu;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return tu +" " + cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("VANBAN.in"));

        Map<String, Integer> map = new HashMap<>();
        List<Tu> list = new ArrayList<>();

        int t = Integer.parseInt(sc.nextLine());
        while (t-->0) {
            String[] line = sc.nextLine().trim().toLowerCase()
                    .split("[^\\p{L}\\p{N}]+");
            for (String s : line) {
                if (!s.isEmpty())
                    map.merge(s, 1, Integer::sum);
            }
        }

        for (String key : map.keySet()) {
            list.add(new Tu(key, map.get(key)));
        }

        list.sort((a, b) -> {
            if (a.cnt==b.cnt) return a.tu.compareTo(b.tu);
            return b.cnt - a.cnt;
        });

        for (Tu item : list) {
            System.out.println(item);
        }
    }
}
