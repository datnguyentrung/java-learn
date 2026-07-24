package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05059 { // XÁC ĐỊNH DANH SÁCH TRÚNG TUYỂN
    static String formatDiem(double n) {
        if (n == (int) n) {
            return String.valueOf((int) n);
        }
        return String.valueOf(n);
    }


    static class ThiSinh {
        String ma, ten, ketQua;
        double toan, ly, hoa, diemUT, tongDiem;

        public ThiSinh(String ma, String ten, double toan, double ly, double hoa) {
            this.ma = ma;
            this.ten = ten;
            this.toan = toan;
            this.ly = ly;
            this.hoa = hoa;

            this.diemUT = getDiemUuTien();
            this.tongDiem = toan*2 + ly + hoa + diemUT;
        }

        public double getDiemUuTien(){
            switch (ma.substring(0, 3)){
                case "KV1": return 0.5;
                case "KV2": return 1;
                default: return 2.5;
            }
        }

        public boolean checkDiem(double n){
            return (double) (int) n == n;
        }

        public void setKetQua(double diemChuan) {
            this.ketQua = tongDiem >= diemChuan ? "TRUNG TUYEN" : "TRUOT";
        }

        @Override
        public String toString() {
            return ma + " " + ten + " "
                    + formatDiem(diemUT)
                    + " "
                    + formatDiem(tongDiem)
                    + " "
                    + ketQua;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<ThiSinh> list = new ArrayList<>();

        while (t-- > 0) {
            list.add(new ThiSinh(
                    sc.nextLine(),
                    sc.nextLine(),
                    Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine())
            ));
        }

        list.sort((a, b) -> {
            return Double.compare(b.tongDiem, a.tongDiem);
        });

        int chiTieu = sc.nextInt();

        double diemChuan = 0;
        for (ThiSinh item : list) {
            if (chiTieu-- == 0) break;
            diemChuan = item.tongDiem;
        }

        System.out.printf("%.01f\n", diemChuan);
        for (ThiSinh item : list) {
            item.setKetQua(diemChuan);
            System.out.println(item);
        }
    }
}