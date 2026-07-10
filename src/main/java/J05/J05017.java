package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05017 {
    static int stt = 1;

    static String chuanHoaMa(){
        StringBuilder sb = new StringBuilder("KH");
        if (stt < 10) sb.append("0");
        sb.append(stt++);
        return sb.toString();
    }

    static class KhachHang{
        String ma, ten;
        long tien;

        public KhachHang(String ten, long cu, long moi) {
            this.ma = chuanHoaMa();
            this.ten = ten;
            this.tien = tinhTien(cu, moi);
        }

        public long tinhTien(long cu, long moi){
            long soNuoc = moi - cu;
            long tien = 0;

            if (soNuoc <= 50){
                tien = soNuoc * 100;
                tien = Math.round(tien * 1.02);
            } else if (soNuoc <= 100) {
                tien = 50 * 100 + (soNuoc-50) * 150;
                tien = Math.round(tien * 1.03);
            } else {
                tien = 50 * 100 + 50 * 150 + (soNuoc-100) * 200;
                tien = Math.round(tien * 1.05);
            }
            return tien;
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+tien;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<KhachHang> khachHangs = new ArrayList<>();

        while(t-- > 0){
            khachHangs.add(new KhachHang(
                    sc.nextLine(), sc.nextLong(), sc.nextLong()
            ));
            sc.nextLine();
        }

        khachHangs.sort((a, b) -> Long.compare(b.tien, a.tien));

        for (KhachHang item : khachHangs){
            System.out.println(item);
        }
    }
}