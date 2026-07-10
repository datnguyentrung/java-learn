package J04;

import java.util.Objects;
import java.util.Scanner;

public class J04013 {
    static class ThiSinh{
        private String ma, ten;
        double toan, ly, hoa, diemUuTien, tongDiem;

        public ThiSinh(String ma, String ten, double toan, double ly, double hoa) {
            this.ma = ma;
            this.ten = ten;
            this.toan = toan;
            this.ly = ly;
            this.hoa = hoa;
            this.diemUuTien = diemUuTien(ma.substring(0,3));
            this.tongDiem = toan*2 + ly + hoa;
        }

        public double diemUuTien(String s){
            if (Objects.equals(s, "KV1")) return 0.5;
            if (Objects.equals(s, "KV2")) return 1.0;
            else return 2.5;
        }

        public String ketQua(){
            return tongDiem + diemUuTien >= 24 ? "TRUNG TUYEN" : "TRUOT";
        }

        @Override
        public String toString(){
            String finalDiemUuTien, finalTongDiem;
            if (diemUuTien == (long) diemUuTien){
                finalDiemUuTien = String.valueOf((long) diemUuTien);
            } else finalDiemUuTien = String.valueOf(diemUuTien);

            if (tongDiem == (long) tongDiem){
                finalTongDiem = String.valueOf((long) tongDiem);
            } else finalTongDiem = String.valueOf(tongDiem);

            return ma+" "+ten+" "+finalDiemUuTien+" "+finalTongDiem+" "+ketQua();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(new ThiSinh(
                sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble()
        ));
    }
}
