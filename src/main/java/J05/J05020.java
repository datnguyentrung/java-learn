package J05;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class J05020 {
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

        int t = sc.nextInt();
        sc.nextLine();

        List<SinhVien> sinhViens = new ArrayList<>();

        while (t-- > 0) {
            sinhViens.add(new SinhVien(
                    sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()
            ));
        }

        sinhViens.sort((a, b) -> {
            if (a.lop.equals(b.lop)) return a.ma.compareTo(b.ma);
            return a.lop.compareTo(b.lop);
        });

        for (SinhVien item : sinhViens) {
            System.out.println(item);
        }
    }
}