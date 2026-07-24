package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05062 { // HỌC BỔNG SINH VIÊN
    static class HocBong {
        String ten;
        double tbc;
        int rl;

        public HocBong(String ten, double tbc, int rl) {
            this.ten = ten;
            this.tbc = tbc;
            this.rl = rl;
        }

        public String getHB(){
            if (tbc >= 3.6 && rl >= 90) return "XUATSAC";
            else if (tbc >= 3.2 && rl >= 80) {
                return "GIOI";
            } else if (tbc >= 2.5 && rl >= 70) {
                return "KHA";
            } else return "KHONG";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        List<HocBong> list = new ArrayList<>();

        while (t-- > 0) {
            list.add(new HocBong(
                    sc.nextLine(),
                    sc.nextDouble(), sc.nextInt()
            ));
            sc.nextLine();
        }

        List<HocBong> sortList = new ArrayList<>(list);

        sortList.sort((a, b) -> {
            return Double.compare(b.tbc, a.tbc);
        });

        double minTbc = sortList.get(m-1).tbc;

        for (HocBong item : list) {
            if (item.tbc >= minTbc) {
                System.out.println(item.ten + ": " + item.getHB());
            } else {
                System.out.println(item.ten + ": KHONG");
            }
        }
    }
}