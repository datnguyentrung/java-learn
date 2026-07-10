package J05;

import java.util.*;

public class J05024 {
    static class SinhVien{
        String ma, ten, lop, email;
        String nganh;

        public SinhVien(String ma, String ten, String lop, String email) {
            this.ma = ma;
            this.ten = ten;
            this.lop = lop;
            this.email = email;
            this.nganh = chuanHoaMaNganh(ma.substring(3, 7));
        }

        public String chuanHoaMaNganh(String ma){
            switch (ma){
                case "DCCN":
                    return "Cong nghe thong tin";
                case "DCKT":
                    return "Ke toan";
                case "DCAT":
                    return "An toan thong tin";
                case "DCVT":
                    return "Vien thong";
                default:
                    return "Dien tu";
            }
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

            String maNganh = ma.substring(3, 7);

            if ((maNganh.equals("DCCN") || maNganh.equals("DCAT")) && lop.charAt(0) == 'E') {
                continue;
            }

            map.computeIfAbsent(sinhVien.nganh, k -> new ArrayList<>()).add(sinhVien);
        }

        int q = sc.nextInt();
        sc.nextLine();

        while (q-->0){
            String s = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN NGANH " + s.toUpperCase() + ":");

            for (SinhVien sv : map.getOrDefault(s, new ArrayList<>())){
                System.out.println(sv);
            }
        }
    }
}