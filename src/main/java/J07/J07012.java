package J07;

import java.io.*;
import java.util.*;

public class J07012 {
    static class Tu {
        String tu;
        int cnt;

        public Tu(String tu, Integer cnt) {
            this.tu = tu;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return tu+" "+cnt;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("DATA.in")
                )
        );

        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> line = (ArrayList<String>) inputStream.readObject();

        for (String s : line) {
            String[] split = s.trim().toLowerCase()
                    .split("[^\\p{L}\\p{N}]+");
            for (String tu : split) {
                if (!tu.isEmpty()) map.merge(tu, 1, Integer::sum);
            }
        }

        List<Tu> list = new ArrayList<>();

        for (String s : map.keySet()) {
            list.add(new Tu(
                    s, map.get(s)
            ));
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
