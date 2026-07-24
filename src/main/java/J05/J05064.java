package J05;

import java.util.*;

public class J05064 { // BẢNG THU NHẬP GIÁO VIÊN
    static class GiaoVien {
        String ma, ten;
        long luongcb, phuCap, thuNhap;
        int bacLuong;

        public GiaoVien(String ma, String ten, long luongcb) {
            this.ma = ma;
            this.ten = ten;
            this.luongcb = luongcb;

            this.phuCap = phuCap();
            this.bacLuong = Integer.parseInt(ma.substring(2));
            this.thuNhap = luongcb * bacLuong + phuCap;
        }

        public Long phuCap(){
            switch (ma.substring(0, 2)){
                case "HT": return 2000000L;
                case "HP": return 900000L;
                default: return 500000L;
            }
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+bacLuong+" "+phuCap+" "+thuNhap;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        List<GiaoVien> list = new ArrayList<>();
        int HT = 1, HP = 2;

        while(t-->0){
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            long luongcb = Long.parseLong(sc.nextLine());

            if (ma.startsWith("HT")) {
                if (HT == 0) continue;
                else HT--;
            } else if (ma.startsWith("HP")) {
                if (HP == 0) continue;
                else HP--;
            }

            list.add( new GiaoVien(
                    ma, ten, luongcb
            ));
        }

        for (GiaoVien item : list) System.out.println(item);
    }
}