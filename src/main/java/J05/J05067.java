package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05067 { // QUẢN LÝ KHO XĂNG DẦU

    static class Xang {
        String ma, ten;
        int soLuong;
        long donGia, tong, thanhTien;
        double thue;

        public Xang(String ma, int soLuong) {
            this.ma = ma;
            this.soLuong = soLuong;
            chuanHoa();

            this.thanhTien = (long) (tong + thue);
        }

        public void chuanHoa() {
            switch (ma.charAt(0)) {
                case 'X': {
                    this.donGia = 128000L;
                    this.tong = soLuong * donGia;
                    this.thue = 0.03 * tong;
                    break;
                }
                case 'D': {
                    this.donGia = 11200L;
                    this.tong = soLuong * donGia;
                    this.thue = 0.035 * soLuong * donGia;
                    break;
                }
                default: {
                    this.donGia = 9700L;
                    this.tong = soLuong * donGia;
                    this.thue = 0.02 * soLuong * donGia;
                    break;
                }
            }

            switch (ma.substring(3)) {
                case "BP": {
                    ten = "British Petro";
                    break;
                }
                case "ES": {
                    ten = "Esso";
                    break;
                }
                case "SH": {
                    ten = "Shell";
                    break;
                }
                case "CA": {
                    ten = "Castrol";
                    break;
                }
                case "MO": {
                    ten = "Mobil";
                    break;
                }
                default: {
                    ten = "Trong Nuoc";
                    this.thue = 0;
                    break;
                }
            }
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + donGia + " " + (int) thue + " " + thanhTien;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        List<Xang> list = new ArrayList<>();

        while (t-- > 0) {
            list.add(new Xang(
                    sc.next(), sc.nextInt()
            ));
        }

        list.sort((a, b) -> Long.compare(b.thanhTien, a.thanhTien));

        for (Xang item : list) {
            System.out.println(item);
        }

    }
}