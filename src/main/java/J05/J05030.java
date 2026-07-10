package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05030 {
    static int id = 1;

    static class SinhVien{
        String ma, ten, lop;
        double d1, d2, d3;

        public SinhVien(String ma, String ten, String lop, double d1, double d2, double d3) {
            this.ma = ma;
            this.ten = ten;
            this.lop = lop;
            this.d1 = d1;
            this.d2 = d2;
            this.d3 = d3;
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+lop+" "+String.format("%.1f", d1)+" "+String.format("%.1f", d2)+" "+String.format("%.1f", d3);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<SinhVien> list = new ArrayList<>();

        while (t-- > 0){
            list.add(new SinhVien(
                    sc.nextLine(), sc.nextLine(), sc.nextLine(),
                    sc.nextDouble(), sc.nextDouble(), sc.nextDouble()
            ));
            sc.nextLine();
        }

        list.sort((a, b) -> {
            return a.ma.compareTo(b.ma);
        });

        for (SinhVien sv : list){
            System.out.printf("%d ", id++);
            System.out.println(sv);
        }
    }
}