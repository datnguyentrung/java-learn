package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05052 { // TRA CỨU ĐƠN HÀNG
    static class MatHang {
        String ten, ma, stt;
        long donGia, soLuong, giamGia, thanhTien;

        public MatHang(String ten, String ma, long donGia, long soLuong) {
            this.ten = ten;
            this.ma = ma;
            this.stt = ma.substring(1, 4);
            this.donGia = donGia;
            this.soLuong = soLuong;

            this.giamGia = (long) (ma.substring(4).equals("1") ? 0.5*donGia*soLuong : 0.3*donGia*soLuong);
            this.thanhTien = donGia*soLuong-giamGia;
        }

        @Override
        public String toString(){
            return ten+" "+ma+" "+stt+" "+giamGia+" "+thanhTien;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<MatHang> list = new ArrayList<>();

        while (t-- > 0) {
            list.add(new MatHang(
                    sc.nextLine(),
                    sc.nextLine(),
                    Long.parseLong(sc.nextLine()),
                    Long.parseLong(sc.nextLine())
            ));
        }

        for (MatHang item : list) {
            System.out.println(item);
        }
    }
}