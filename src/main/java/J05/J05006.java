package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05006 {
    static int stt = 1;

    static class NhanVien{
        String ma, ten, gioiTinh, ngaySinh, diaChi, thue, ngayKy;

        public NhanVien(String ten, String gioiTinh, String ngaySinh, String diaChi, String thue, String ngayKy) {
            this.ma = chuanHoaStt();
            stt++;

            this.ten = ten;
            this.gioiTinh = gioiTinh;
            this.ngaySinh = chuanHoaSinh(ngaySinh);
            this.diaChi = diaChi;
            this.thue = thue;
            this.ngayKy = chuanHoaSinh(ngayKy);
        }

        public String chuanHoaStt(){
            StringBuilder ma = new StringBuilder(String.valueOf(stt));

            int len = ma.length();
            while (len++ < 5){
                ma.insert(0, "0");
            }

            return ma.toString();
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
            return ma+" "+ten+" "+gioiTinh+" "+ngaySinh+" "+diaChi+" "+thue+" "+ngayKy;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<NhanVien> nhanViens = new ArrayList<>();

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0){
            nhanViens.add(new NhanVien(
                    sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()
            ));
        }

        for (NhanVien nhanVien : nhanViens){
            System.out.println(nhanVien);
        }
    }
}
