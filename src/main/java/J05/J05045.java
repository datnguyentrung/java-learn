package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05045 { // SẮP XẾP NHÂN VIÊN THEO THU NHẬP
    static int id = 1;

    static class NhanVien{
        String stt, ten, chucVu;
        long luong, soNgay,phuCap, luongChinh, tamUng, thuNhap;

        public NhanVien(String ten, long luong, long soNgay, String chucVu) {
            this.stt = "NV" + String.format("%02d", id++);
            this.ten = ten;
            this.chucVu = chucVu;
            this.luong = luong;
            this.soNgay = soNgay;

            this.luongChinh = luong*soNgay;
            this.phuCap = phuCap();
            this.tamUng = tamUng();
            this.thuNhap = luongChinh + phuCap;
        }

        public Long phuCap(){
            switch (chucVu){
                case "GD": return 500L;
                case "PGD": return 400L;
                case "TP": return 300L;
                case "KT": return 250L;
                default: return 100L;
            }
        }

        public Long tamUng(){
            long ans = Math.round((phuCap + luongChinh) * 2.0 / 3000) * 1000;
            return Math.min(ans, 25000);
        }

        @Override
        public String toString() {
            long conLai = phuCap + luongChinh - tamUng;

            return stt + " "
                    + ten + " "
                    + phuCap + " "
                    + luongChinh + " "
                    + tamUng + " "
                    + conLai;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<NhanVien> list = new ArrayList<>();

        while (t-->0) {
            String ten = sc.nextLine();
            String chucVu = sc.nextLine();
            long luongNgay = Long.parseLong(sc.nextLine());
            long soNgay = Long.parseLong(sc.nextLine());


            list.add(new NhanVien(ten, luongNgay, soNgay, chucVu));
        }

        list.sort((a, b) -> {
            return a.thuNhap == b.thuNhap ? a.stt.compareTo(b.stt) : Long.compare(b.thuNhap, a.thuNhap);
        });

        for (NhanVien item : list) {
            System.out.println(item);
        }
    }
}