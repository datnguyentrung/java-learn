package J04;

import java.math.BigInteger;
import java.util.Scanner;

public class J04015 {
    static class GiaoVien{
        private String ma, ten;
        private long salary, phuCap;
        private int heSoBacLuong;

        public GiaoVien(String ma, String ten, long salary) {
            this.ma = ma;
            this.ten = ten;
            this.salary = salary;
            this.phuCap = phuCap(ma.substring(0, 2));
            this.heSoBacLuong = Integer.parseInt(ma.substring(2));
        }

        public long phuCap(String ma){
            if (ma.equals("HT")) return 2000000;
            if (ma.equals("HP")) return 900000;
            else return 500000;
        }

        public long thuNhap(){
            return salary * heSoBacLuong + phuCap;
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+heSoBacLuong+" "+phuCap+" "+thuNhap();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(new GiaoVien(
                sc.nextLine(), sc.nextLine(), sc.nextLong()
        ));
    }
}
