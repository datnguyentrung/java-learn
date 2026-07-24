package test.T2;

import java.util.Scanner;

public class B1 {
    static int stt = 1;

    static class SanPham{
        String ten, nhaSX, ma;
        int soLuong;
        double gia, thanhTien;

        public SanPham(String ten, int soLuong,String nhaSX, double gia) {
            this.ten = ten;
            this.nhaSX = nhaSX;
            this.soLuong = soLuong;
            this.gia = gia;

            this.ma = nhaSX.toUpperCase() + String.format("-%03d", stt++);
            this.thanhTien = getThanhTien();
        }

        public double getThanhTien(){
            if (soLuong < 20) return soLuong * gia;
            else return soLuong * gia * 0.9;
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+soLuong+" "
                    +String.format("%.01f", gia)+" "
                    +String.format("%.01f", thanhTien);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        SanPham s;
        for (int i = 0; i < n; i++){
            s = new SanPham(sc.nextLine(),
                    Integer.parseInt(sc.nextLine()),
                    sc.nextLine(),Double.parseDouble(sc.nextLine()));
            System.out.println(s.toString());
        }
    }
}
