package J05;

import java.util.*;

public class J05049 { // LIỆT KÊ NHẬP XUẤT HÀNG THEO NHÓM
    static Map<String, Integer> mp = new HashMap<>();

    static class MatHang{
        String ma;
        Long soLuongNhap, soLuongXuat, donGia, tien, thue;

        public MatHang(String ma, Long soLuongNhap) {
            this.ma = ma;
            this.soLuongNhap = soLuongNhap;
            this.soLuongXuat = Math.round(ma.charAt(0) == 'A' ? 0.6 * soLuongNhap : 0.7*soLuongNhap);
            this.donGia = ma.charAt(4) == 'Y' ? 110000L : 135000L;
            this.tien = soLuongXuat*donGia;
            this.thue = tinhThue(ma.charAt(0), ma.charAt(4));
        }

        public long tinhThue(char dau, char cuoi){
            if (dau == 'A' && cuoi == 'Y') return (long) (tien * 0.08);
            else if (dau == 'A' && cuoi == 'N') return (long) (tien * 0.11);
            else if (dau == 'B' && cuoi == 'Y') return (long) (tien * 0.17);
            else return (long) (tien * 0.22);
        }

        @Override
        public String toString(){
            return ma+" "+soLuongNhap+" "+soLuongXuat+" "+donGia+" "+tien+" "+thue;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<MatHang> list = new ArrayList<>();

        while (t-->0) {
            list.add(new MatHang(
                    sc.nextLine(),
                    Long.parseLong(sc.nextLine())
            ));
        }

        list.sort((a, b) ->{
            return Long.compare(b.thue, a.thue);
        });

        String search = sc.nextLine();
        for (MatHang item : list) {
            if (item.ma.charAt(0) == search.charAt(0))System.out.println(item);
        }
    }
}