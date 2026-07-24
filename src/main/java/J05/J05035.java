package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05035 {
    static int id = 1;

    static class SinhVien{
        int stt;
        String ma, ten, lop, email, doanhNghiep;

        public SinhVien(String ma, String ten, String lop, String email, String doanhNghiep) {
            this.stt = id++;
            this.ma = ma;
            this.ten = ten;
            this.lop = lop;
            this.email = email;
            this.doanhNghiep = doanhNghiep;
        }

        @Override
        public String toString(){
            return stt+" "+ma+" "+ten+" "+lop+" "+email+" "+doanhNghiep;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<SinhVien> list = new ArrayList<>();

        while (t-- > 0){
            list.add(new SinhVien(
                    sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()
            ));
        }

        list.sort((a, b) -> {
            return a.ma.compareTo(b.ma);
        });

        int q = sc.nextInt();
        sc.nextLine();

        while (q-- > 0){
            String search = sc.nextLine();

            for (SinhVien item : list){
                if (item.doanhNghiep.equals(search)) System.out.println(item);
            }
        }
    }
}