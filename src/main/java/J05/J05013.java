package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05013 {
    static int stt = 1;

    static class NhanVien{
        String ma, ten;
        double d1, d2, dtb;

        public NhanVien(String ten, double d1, double d2) {
            this.ma = chuanHoaMa();
            this.ten = ten;
            this.d1 = chuanHoaDiem(d1);
            this.d2 = chuanHoaDiem(d2);
            this.dtb = (this.d1 + this.d2) / 2;
        }

        public String chuanHoaMa(){
            StringBuilder sb = new StringBuilder("TS");
            if (String.valueOf(stt).length() == 1) sb.append(0);
            sb.append(stt++);
            return sb.toString();
        }

        public double chuanHoaDiem(double diem){
            if (diem <= 10) return diem;
            return diem/10;
        }

        public String ketQua(){
            if (dtb < 5) return "TRUOT";
            if (dtb < 8) return "CAN NHAC";
            if (dtb <= 9.5) return "DAT";
            else return "XUAT SAC";
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+String.format("%.2f", dtb)+" "+ketQua();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<NhanVien> nhanViens = new ArrayList<>();

        while(t-- > 0){
            nhanViens.add(new NhanVien(
                    sc.nextLine(), sc.nextDouble(), sc.nextDouble()
            ));
            sc.nextLine();
        }

        nhanViens.sort((a, b) -> {
            return Double.compare(b.dtb, a.dtb);
        });

        for (NhanVien nv : nhanViens){
            System.out.println(nv);
        }
    }
}
