package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05034 {
    static int stt = 1;

    static class DoanhNghiep{
        String ma, ten, lop, email, dn;
        int id;

        public DoanhNghiep(String ma, String ten, String lop, String email, String dn) {
            this.ma = ma;
            this.ten = ten;
            this.lop = lop;
            this.email = email;
            this.dn = dn;
            this.id = stt++;
        }

        @Override
        public String toString(){
            return id+" "+ma+" "+ten+" "+lop+" "+email+" "+dn;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<DoanhNghiep> list = new ArrayList<>();

        while (t-- > 0){
            list.add(new DoanhNghiep(
                    sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()
            ));
        }

        list.sort((a, b) -> {
            return a.ten.compareTo(b.ten);
        });

        int q = sc.nextInt();
        sc.nextLine();

        while (q-- > 0){
            String search = sc.nextLine();

            for (DoanhNghiep item : list){
                if (item.dn.equals(search)) System.out.println(item);
            }
        }

    }
}