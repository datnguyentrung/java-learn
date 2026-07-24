package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05036 {
    static int id = 1;

    static class MatHang{
        String ma, ten, donVi;
        Integer donGia, soLuong;

        public MatHang(String ten, String donVi, Integer donGia, Integer soLuong) {
            this.ma = chuanHoaMa();
            this.ten = ten;
            this.donVi = donVi;
            this.donGia = donGia;
            this.soLuong = soLuong;
        }

        public String chuanHoaMa(){
            if (id < 10) return "MH0" + id++;
            else return "MH" + id++;
        }

        public long phiVanChuyen() {
            long tienNhap = donGia * soLuong;
            return Math.round(tienNhap * 0.05);
        }

        public long thanhTien() {
            return donGia * soLuong + phiVanChuyen();
        }

        public long giaBan() {
            return Math.round(thanhTien() * 1.02);
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+donVi+" "+phiVanChuyen()+" "+thanhTien()+" "+giaBan();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<MatHang> list = new ArrayList<>();

        while (t-- > 0){
            list.add(new MatHang(
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextInt(),
                    sc.nextInt()
            ));
            sc.nextLine();
        }

        for (MatHang item : list) System.out.println(item);
    }
}