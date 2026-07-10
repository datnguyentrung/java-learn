package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05027 {
    static int stt = 1;

    static String chuanHoaNganh(String s){
        String[] strings = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String tu : strings){
            sb.append(Character.toUpperCase(tu.charAt(0)));
        }
        return sb.toString();
    }

    static class GiangVien{
        String ma, fullName, nganh, search;

        public GiangVien(String fullName, String nganh) {
            this.ma = chuanHoaMa();
            this.fullName = fullName;
            this.nganh = chuanHoaNganh(nganh);
            this.search = fullName.toLowerCase();
        }

        public String chuanHoaMa(){
            StringBuilder sb = new StringBuilder("GV");
            if (stt < 10) sb.append("0");
            sb.append(stt++);
            return sb.toString();
        }

        @Override
        public String toString(){
            return ma+" "+fullName+" "+nganh;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<GiangVien> giangViens = new ArrayList<>();

        while (t-- > 0){
            giangViens.add(new GiangVien(sc.nextLine(), sc.nextLine()));
        }

        int q = sc.nextInt();
        sc.nextLine();
        while (q-->0){
            String search = sc.nextLine();

            System.out.println("DANH SACH GIANG VIEN THEO TU KHOA " + search + ":");

            for (GiangVien gv : giangViens){
                if (gv.search.contains(search.toLowerCase())) System.out.println(gv);
            }
        }
    }
}