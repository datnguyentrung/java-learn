package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05029 {
    static class DoanhNghiep{
        String ma, ten;
        int sv;

        public DoanhNghiep(String ma, String ten, int sv) {
            this.ma = ma;
            this.ten = ten;
            this.sv = sv;
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+sv;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<DoanhNghiep> list = new ArrayList<>();

        while (t-- > 0){
            list.add(new DoanhNghiep(sc.nextLine(), sc.nextLine(), sc.nextInt()));
            sc.nextLine();
        }

        list.sort((a, b) -> {
            if (a.sv == b.sv) return a.ma.compareTo(b.ma);
            return b.sv - a.sv;
        });

        int q = sc.nextInt();
        sc.nextLine();

        while (q-->0){
            int st = sc.nextInt(), en = sc.nextInt();

            System.out.printf("DANH SACH DOANH NGHIEP NHAN TU %d DEN %d SINH VIEN:\n", st, en);
            for (DoanhNghiep item : list) {
                if (item.sv >= st && item.sv <= en) System.out.println(item);
            }
        }


    }
}