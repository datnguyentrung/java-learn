package J05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05005 {
    static int stt = 1;

    static class SinhVien{
        String ma, ten, lop, sinh;
        String diem;
        float gpa;

        public SinhVien(String ten, String lop, String sinh, Float diem) {
            this.ma = chuanHoaStt();
            stt++;
            
            this.ten = chuanHoaTen(ten);
            this.lop = lop;
            this.sinh = chuanHoaSinh(sinh);
            this.diem = String.format("%.2f", diem);
            this.gpa = diem;
        }

        public String chuanHoaStt(){
            String ma = String.valueOf(stt);

            if (ma.length() == 1) ma = "00" + ma;
            else if (ma.length() == 2) ma = "0" + ma;

            return "B20DCCN" + ma;
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

        public String chuanHoaSinh(String sinh){
            String[] list = sinh.trim().split("/");
            String ngay = list[0].length() == 1 ? "0" + list[0] : list[0];
            String thang = list[1].length() == 1 ? "0" + list[1] : list[1];

            return ngay+"/"+thang+"/"+list[2];
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+lop+" "+sinh+" "+diem;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<SinhVien> sinhViens = new ArrayList<>();

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0){
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String sinh = sc.nextLine();
            Float diem = Float.parseFloat(sc.nextLine());

            sinhViens.add(new SinhVien(ten, lop, sinh, diem));
        }

        sinhViens.sort((a, b) -> Float.compare(b.gpa, a.gpa));

        for (SinhVien sinhVien : sinhViens){
            System.out.println(sinhVien);
        }
    }
}
