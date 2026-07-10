package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05012 {
    static class MatHang{
        String ma, ten;
        long soLuong, gia, chietKhau, tong;

        public MatHang(String ma, String ten, long soLuong, long gia, long chietKhau) {
            this.ma = ma;
            this.ten = ten;
            this.soLuong = soLuong;
            this.gia = gia;
            this.chietKhau = chietKhau;
            this.tong = gia * soLuong - chietKhau;
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+soLuong+" "+gia+" "+chietKhau+" "+tong;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<MatHang> matHangs = new ArrayList<>();

        while (t-- > 0){
            matHangs.add(new MatHang(
                    sc.nextLine(), sc.nextLine(),
                    sc.nextLong(), sc.nextLong(), sc.nextLong()
            ));
            sc.nextLine();
        }

        matHangs.sort((a, b) -> {
            return Long.compare(b.tong, a.tong);
        });

        for (MatHang matHang : matHangs){
            System.out.println(matHang);
        }
    }
}
