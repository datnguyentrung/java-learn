package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05021 {
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

        List<SinhVien> sinhViens = new ArrayList<>();

        while (sc.hasNext()) {
            sinhViens.add(new SinhVien(
                    sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()
            ));
        }

        sinhViens.sort((a, b) -> {
            return a.ma.compareTo(b.ma);
        });

        for (SinhVien item : sinhViens) {
            System.out.println(item);
        }
    }
}