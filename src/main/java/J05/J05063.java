package J05;

import java.util.*;

public class J05063 { // HỌC BỔNG SINH VIÊN
    static class Bien {
        int heSo, mu;

        public Bien(int heSo, int mu) {
            this.heSo = heSo;
            this.mu = mu;
        }
    }

    static class DaThuc {
        List<Bien> biens = new ArrayList<>();

        public DaThuc(String line) {
            String[] split = line.trim().split("\\s*\\+\\s*");

            for (String s : split) {
                String[] tach = s.split("\\*?x\\^");
                biens.add(new Bien(
                        Integer.parseInt(tach[0]),
                        Integer.parseInt(tach[1])
                ));
            }
        }

        public DaThuc() {
        }

        public DaThuc cong(DaThuc other) {
            TreeMap<Integer, Integer> map = new TreeMap<>(
                    (a, b) -> Integer.compare(b, a));

            for (Bien bien : this.biens) {
                map.put(
                        bien.mu,
                        map.getOrDefault(bien.mu, 0) + bien.heSo
                );
            }

            for (Bien bien : other.biens) {
                map.put(
                        bien.mu,
                        map.getOrDefault(bien.mu, 0) + bien.heSo
                );
            }

            DaThuc ketQua = new DaThuc();

            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                int mu = entry.getKey();
                int heSo = entry.getValue();

                if (heSo != 0) {
                    ketQua.biens.add(new Bien(heSo, mu));
                }
            }

            return ketQua;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < biens.size(); i++) {
                Bien bien = biens.get(i);

                if (i > 0) {
                    result.append(" + ");
                }

                result.append(bien.heSo)
                        .append("*x^")
                        .append(bien.mu);
            }

            return result.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
    }
}