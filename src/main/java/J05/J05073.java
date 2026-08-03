package J05;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05073 { // TÍNH CƯỚC ĐIỆN THOẠI CỐ ĐỊNH - 1
    static class SanPham {
        String ma;
        Long donGia, soLuong;
        double thue, phiVC, tienHang, tong;

        public SanPham(String ma, Long donGia, Long soLuong) {
            this.ma = ma;
            this.donGia = donGia;
            this.soLuong = soLuong;

            this.tienHang = donGia * soLuong;
            chuanHoa();

            tong = (tienHang+thue+phiVC)*1.2/soLuong;
        }

        public void chuanHoa(){
            switch (ma.charAt(0)){
                case 'T': {
                    thue = 0.29 * tienHang;
                    phiVC = 0.04 * tienHang;
                    break;
                }
                case 'C': {
                    thue = 0.1 * tienHang;
                    phiVC = 0.03 * tienHang;
                    break;
                }
                case 'D': {
                    thue = 0.08 * tienHang;
                    phiVC = 0.025 * tienHang;
                    break;
                }
                default: {
                    thue = 0.02 * tienHang;
                    phiVC = 0.005 * tienHang;
                }
            }
            if (ma.charAt(ma.length()-1) == 'C') thue = 0.95*thue;
        }

        @Override
        public String toString(){
            return ma+" "+String.format("%.02f", tong);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        List<SanPham> list = new ArrayList<>();

        while(t-->0){
            list.add( new SanPham(
                    sc.next(), sc.nextLong(), sc.nextLong()
            ));
        }

        for (SanPham item : list) {
            System.out.println(item);
        }
    }
}