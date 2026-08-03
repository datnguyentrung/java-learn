package test.T3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class B5 {
    static int stt = 1;

    static class HocSinh {
        String ma, ten, lop, sinh;
        double diem;

        public HocSinh(String ten, String lop, String sinh, double diem) {
            this.ma = String.format("B20DCCN%03d", stt++);

            this.ten = chuanHoaTen(ten);
            this.lop = lop;
            this.sinh = chuanHoaNgay(sinh);
            this.diem = diem;
        }

        public String chuanHoaTen(String ten){
            String[] list = ten.toLowerCase().trim().split("\\s+");

            StringBuilder sb = new StringBuilder();
            for (String s : list){
                String tu = Character.toUpperCase(s.charAt(0)) + s.substring(1);
                sb.append(tu).append(" ");
            }
            return sb.toString().trim();
        }

        public String chuanHoaNgay(String s){
            String[] list = s.trim().split("/");
            String ngay = list[0].length() == 1 ? "0" + list[0] : list[0];
            String thang = list[1].length() == 1 ? "0" + list[1] : list[1];

            return ngay+"/"+thang+"/"+list[2];
        }

        @Override
        public String toString() {
            return ma+" "+ten+" "+lop+" "+sinh+String.format(" %.02f", diem);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        List<HocSinh> hocSinhs = new ArrayList<>();

        while (t-->0) {
            hocSinhs.add(new HocSinh(
                    sc.nextLine(), sc.nextLine(), sc.nextLine(),
                    Double.parseDouble(sc.nextLine())
            ));
        }

        hocSinhs.sort((a, b) -> {
            return Double.compare(b.diem, a.diem);
        });

        for (HocSinh item : hocSinhs) {
            System.out.println(item);
        }
    }
}
