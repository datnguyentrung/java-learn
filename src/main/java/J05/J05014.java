package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05014 {
    static int stt = 1;

    static class GiaoVien{
        String ten, ma, mon;
        double tinHoc, chuyenMon, tong;

        public GiaoVien(String ten, String maXetTuyen, double tinHoc, double chuyenMon) {
            this.ten = ten;
            this.ma = chuanHoaMa();
            this.tinHoc = tinHoc;
            this.chuyenMon = chuyenMon;
            this.tong = tinHoc*2 + chuyenMon + diemUuTien(maXetTuyen.charAt(1));
            this.mon = monHoc(maXetTuyen.charAt(0));
        }

        public String chuanHoaMa(){
            StringBuilder sb = new StringBuilder("GV");
            if (String.valueOf(stt).length() == 1) sb.append(0);
            sb.append(stt++);
            return sb.toString();
        }

        public double diemUuTien(Character s){
            switch (s){
                case '1':
                    return 2.0;
                case '2':
                    return 1.5;
                case '3':
                    return 1.0;
                default:
                    return 0.0;
            }
        }

        public String monHoc(Character s){
            switch (s){
                case 'A':
                    return "TOAN";
                case 'B':
                    return "LY";
                default:
                    return "HOA";
            }
        }

        public String ketQua(){
            if (tong >= 18) return "TRUNG TUYEN";
            else return "LOAI";
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+mon+" "+tong+" "+ketQua();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<GiaoVien> giaoViens = new ArrayList<>();

        while(t-->0){
            giaoViens.add(new GiaoVien(
                    sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble()
            ));
            sc.nextLine();
        }

        giaoViens.sort((a, b) -> {
            return Double.compare(b.tong, a.tong);
        });

        for (GiaoVien gv : giaoViens){
            System.out.println(gv);
        }
    }
}
