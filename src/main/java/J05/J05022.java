package J05;

import java.util.*;

public class J05022 {
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

            SinhVien sinhVien = new SinhVien(
                    ma, ten, lop, email
            );

            map.computeIfAbsent(lop, k -> new ArrayList<>()).add(sinhVien);
        }

        int q = sc.nextInt();
        sc.nextLine();

        while (q-->0){
            String s = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN LOP " + s + ":");

            for (SinhVien sv : map.get(s)){
                System.out.println(sv);
            }
        }
    }
}