package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05015 {
    static class ThanhTich{
        String ten, donVi, thoiGian;
        int tocDo;
        double duration;

        public ThanhTich(String ten, String donVi, String thoiGian) {
            this.ten = ten;
            this.donVi = donVi;
            this.thoiGian = thoiGian;
            this.tocDo = getTocDo(thoiGian);
        }

        public int getTocDo(String thoiGian){
            String[] list = thoiGian.trim().split(":");
            double gio = Double.parseDouble(list[0]), phut = Double.parseDouble(list[1]);

            this.duration = (gio - 6) + phut/60;
            return (int) Math.round(120 / duration);
        }

        public String chuanHoaMa(){
            String[] list1 = donVi.trim().split("\\s+");
            String[] list2 = ten.trim().split("\\s+");

            StringBuilder sb = new StringBuilder();
            for (String s : list1) sb.append(Character.toUpperCase(s.charAt(0)));

            for (String s : list2) sb.append(Character.toUpperCase(s.charAt(0)));

            return sb.toString();
        }

        @Override
        public String toString(){
            return chuanHoaMa()+" "+ten+" "+donVi+" "+tocDo+" Km/h";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<ThanhTich> thanhTiches = new ArrayList<>();

        while(t-->0){
            thanhTiches.add(new ThanhTich(
                    sc.nextLine(), sc.nextLine(), sc.nextLine()
            ));
//            sc.nextLine();
        }

        thanhTiches.sort((a, b) -> {
            return Double.compare(a.duration, b.duration);
        });

        for (ThanhTich tt : thanhTiches){
            System.out.println(tt);
        }
    }
}
