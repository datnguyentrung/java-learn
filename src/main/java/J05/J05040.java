package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05040 {
    static int id = 1;

    static class NhanVien{
        String stt, ten, chucVu;
        long luong, soNgay, luongThang, thuong, phuCap, thucLinh;

        public NhanVien(String ten, long luong, long soNgay, String chucVu) {
            this.stt = "NV" + String.format("%02d", id++);
            this.ten = ten;
            this.chucVu = chucVu;
            this.luong = luong;
            this.soNgay = soNgay;

            this.luongThang = luongThang();
            this.phuCap = phuCap();
            this.thuong = thuong();
            this.thucLinh = luongThang + phuCap + thuong;
        }

        public Long luongThang(){
            return luong * soNgay;
        }

        public Long thuong() {
            if (soNgay >= 25) return (long) (luongThang() * 0.2);
            else if (soNgay >= 22) return (long) (luongThang() * 0.1);
            else return 0L;
        }

        public Long phuCap(){
            switch (chucVu){
                case "GD": return 250000L;
                case "PGD": return 200000L;
                case "TP": return 180000L;
                default: return 150000L;
            }
        }

        @Override
        public String toString(){
            return stt+" "+ten+" "+luongThang+" "+thuong+" "+phuCap+" "+thucLinh;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<NhanVien> list = new ArrayList<>();

        while (t-->0) {
            String ten = sc.nextLine();
            long luongNgay = Long.parseLong(sc.nextLine());
            long soNgay = Long.parseLong(sc.nextLine());
            String chucVu = sc.nextLine();

            list.add(new NhanVien(ten, luongNgay, soNgay, chucVu));
        }

        for (NhanVien item : list) {
            System.out.println(item);
        }
    }
}