package J05;

import java.util.*;

public class J05023 {
    static class SinhVien{
        String ma, ten, lop, email;

        public SinhVien(String ma, String ten, String lop, String email) {
            this.ma = ma;
            this.ten = ten;
            this.lop = lop;
            this.email = email;
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+lop+" "+email;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        Map<String, List<SinhVien>> map = new HashMap<>();

        while (t-- > 0) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();

            SinhVien sinhVien = new SinhVien(ma, ten, lop, email);

            String khoa = lop.substring(1, 3);

            map.computeIfAbsent(khoa, k -> new ArrayList<>()).add(sinhVien);
        }

        int q = sc.nextInt();
        sc.nextLine();

        while (q-->0){
            String s = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN KHOA " + s + ":");

            String khoa = s.substring(2);

            for (SinhVien sv : map.getOrDefault(khoa, new ArrayList<>())){
                System.out.println(sv);
            }
        }
    }
}