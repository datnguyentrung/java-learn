package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05066 { // BẢNG THU NHẬP GIÁO VIÊN
    static class NhanVien {
        String ma, ten, chucVu, soHieuNhanVien, heSoLuong;

        public NhanVien(String ma, String ten) {
            this.ten = ten;
            this.chucVu = ma.substring(0, 2);
            this.heSoLuong = ma.substring(2, 4);
            this.soHieuNhanVien = ma.substring(4);

            int soHieu = Integer.parseInt(soHieuNhanVien);

            if (chucVu.equals("GD") && soHieu > 1) {
                chucVu = "NV";
            } else if ((chucVu.equals("TP") || chucVu.equals("PP"))
                    && soHieu > 3) {
                chucVu = "NV";
            }
        }

        @Override
        public String toString(){
            return ten+" "+chucVu+" "+soHieuNhanVien+" "+heSoLuong;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        List<NhanVien> list = new ArrayList<>();

        while(t-->0){
            String[] line = sc.nextLine().trim().split("\\s+");

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < line.length; i++){
                sb.append(line[i]).append(" ");
            }

            list.add( new NhanVien(
                    line[0], sb.toString().trim()
            ));
        }

        int m = Integer.parseInt(sc.nextLine());

        list.sort((a, b) -> {
            return a.heSoLuong.compareTo(b.heSoLuong) == 0
                    ? a.soHieuNhanVien.compareTo(b.soHieuNhanVien)
                    : b.heSoLuong.compareTo(a.heSoLuong);
        });

        while (m-->0) {
            String search = sc.nextLine().trim().toLowerCase();

            for (NhanVien item : list) {
                if (item.ten.toLowerCase().contains(search)) System.out.println(item);
            }
            System.out.println();
        }
    }
}