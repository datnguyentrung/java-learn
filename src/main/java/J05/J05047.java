package J05;

import java.util.*;

public class J05047 { // BẢNG KÊ NHẬP KHO
    static Map<String, Integer> mp = new HashMap<>();

    static class MatHang{
        String ma, ten;
        Long soLuong, donGia, chietKhau, thanhTien;

        public MatHang(String ten, Long soLuong, Long donGia) {
            this.ma = chuanHoaMa(ten);
            this.ten = ten;
            this.soLuong = soLuong;
            this.donGia = donGia;
            this.chietKhau = chietKhau();
            this.thanhTien = soLuong*donGia-chietKhau;
        }

        public String chuanHoaMa(String ten){
            String[] splits = ten.trim().toUpperCase().split("\\s+");
            String ma = "" + splits[0].charAt(0) + splits[1].charAt(0);
            int number = mp.merge(ma, 1, Integer::sum);
            return ma + String.format("%02d", number);
        }

        public Long chietKhau(){
            long tien = donGia * soLuong;
            if (soLuong > 10) return (long) (tien * 0.05);
            else if (soLuong >= 8) {
                return (long) (tien * 0.02);
            } else if (soLuong >= 5) {
                return (long) (tien * 0.01);
            } else return 0L;
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+chietKhau+" "+thanhTien;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<MatHang> list = new ArrayList<>();

        while (t-->0) {
            String ten = sc.nextLine();
            long soLuong = Long.parseLong(sc.nextLine());
            long donGia = Long.parseLong(sc.nextLine());

            list.add(new MatHang(ten, soLuong, donGia));
        }

        list.sort((a, b) ->{
            return Long.compare(b.chietKhau, a.chietKhau);
        });

        for (MatHang item : list) {
            System.out.println(item);
        }
    }
}