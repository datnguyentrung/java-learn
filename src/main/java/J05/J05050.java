package J05;

import java.util.*;

public class J05050 { // TÍNH TIỀN ĐIỆN
    static int cnt = 1;

    static class Dien {
        String loai, ma;
        long cu, moi, heSo, tien, phuTroi, tongTien;

        public Dien(String loai, long cu, long moi) {
            this.loai = loai;
            this.ma = "KH" + String.format("%02d", cnt++);
            this.cu = cu;
            this.moi = moi;

            this.heSo = tinhHeSo();
            this.tien = (moi - cu) * heSo * 550;
            this.phuTroi = tinhPhuTroi();
            this.tongTien = tien + phuTroi;
        }

        public long tinhHeSo() {
            switch (loai) {
                case "KD":
                    return 3;
                case "NN":
                    return 5;
                case "TT":
                    return 4;
                case "CN":
                    return 2;
                default:
                    return 0;
            }
        }

        public long tinhPhuTroi() {
            long soDien = moi - cu;

            if (soDien < 50) {
                return 0;
            } else if (soDien <= 100) {
                // Làm tròn 35% bằng số nguyên, tránh sai số double
                return (tien * 35 + 50) / 100;
            } else {
                return tien;
            }
        }

        @Override
        public String toString() {
            return ma + " " + heSo + " " + tien + " "
                    + phuTroi + " " + tongTien;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        List<Dien> list = new ArrayList<>();

        while (t-- > 0) {
            String loai = sc.next();
            long cu = sc.nextLong();
            long moi = sc.nextLong();

            list.add(new Dien(loai, cu, moi));
        }

        for (Dien item : list) {
            System.out.println(item);
        }
    }
}