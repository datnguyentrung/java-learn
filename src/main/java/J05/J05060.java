package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05060 { // XÁC ĐỊNH DANH SÁCH TRÚNG TUYỂN
    static int stt = 1;

    static String formatDiem(double n) {
        if (n == (int) n) {
            return String.valueOf((int) n);
        }
        return String.valueOf(n);
    }

    static class PhuHo {
        String ten, ngaySinh, ma;
        double lt, th, thuong, diemXL;

        public PhuHo(String ten, String ngaySinh, double lt, double th) {
            this.ma = String.format("PH%02d", stt++);

            this.ten = ten;
            this.ngaySinh = ngaySinh;
            this.lt = lt;
            this.th = th;

            this.thuong = setDiemThuong();

            double tongDiem = Math.round((lt + th)/2 + thuong);
            this.diemXL = tongDiem > 10 ? 10 : tongDiem;
        }

        public double setDiemThuong() {
            if (lt >= 8 && th >= 8) return 1;
            else if (lt >= 7.5 && th >= 7.5) {
                return 0.5;
            } else return 0;
        }

        public String xepLoai(){
            if (diemXL < 5) return "Truot";
            else if (diemXL < 7) {
                return "Trung binh";
            } else if (diemXL < 8){
                return "Kha";
            } else if (diemXL < 9) {
                return "Gioi";
            } else return "Xuat sac";
        }

        public int getTuoi(){
            return 2021 - Integer.parseInt(ngaySinh.substring(6));
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+getTuoi()+" "+formatDiem(diemXL)+" "+xepLoai();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<PhuHo> list = new ArrayList<>();

        while (t-- > 0) {
            list.add(new PhuHo(
                    sc.nextLine(),
                    sc.nextLine(),
                    Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine())
            ));
        }

        for (PhuHo item : list) {
            System.out.println(item);
        }
    }
}