package J05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05016 {
    static int stt = 1;

    static class KhachHang{
        String ma, ten;
        long phong, soNgay, thanhTien;

        public KhachHang(String ten, int phong, String batDau, String ketThuc, int dichVu) {
            this.ma = chuanHoaMa();
            this.ten = ten.trim();
            this.phong = phong;
            this.soNgay = getSoNgay(batDau, ketThuc);
            this.thanhTien = this.soNgay * getGia(phong) + dichVu;
        }

        public String chuanHoaMa(){
            StringBuilder sb = new StringBuilder("KH");
            if (stt < 10) sb.append("0");
            sb.append(stt++);
            return sb.toString();
        }

        public long getSoNgay(String batDau, String ketThuc){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate d1 = LocalDate.parse(batDau.trim(), formatter);
            LocalDate d2 = LocalDate.parse(ketThuc.trim(), formatter);

            return ChronoUnit.DAYS.between(d1, d2) + 1;
        }

        public long getGia(int phong){
            switch (phong / 100){
                case 1:
                    return 25;
                case 2:
                    return 34;
                case 3:
                    return 50;
                default:
                    return 80;
            }
        }

        @Override
        public String toString(){
            return ma + " " + ten + " " + phong + " " + soNgay + " " + thanhTien;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<KhachHang> khachHangs = new ArrayList<>();

        while(t-- > 0){
            String ten = sc.nextLine();

            int phong = sc.nextInt();
            sc.nextLine();

            String batDau = sc.nextLine();
            String ketThuc = sc.nextLine();

            int dichVu = sc.nextInt();
            sc.nextLine();

            khachHangs.add(new KhachHang(ten, phong, batDau, ketThuc, dichVu));
        }

        khachHangs.sort((a, b) -> Long.compare(b.thanhTien, a.thanhTien));

        for (KhachHang item : khachHangs){
            System.out.println(item);
        }
    }
}