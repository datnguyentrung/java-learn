package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05042 {
    static int id = 1;

    static class NhanVien{
        String ten;
        int c;
        long t;

        public NhanVien(String ten, int c, long t) {
            this.ten = ten;
            this.c = c;
            this.t = t;
        }
        @Override
        public String toString(){
            return ten+" "+c+" "+t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        sc.nextLine();

        List<NhanVien> list = new ArrayList<>();

        while (test-->0) {
            String ten = sc.nextLine();
            int c = sc.nextInt();
            long t = sc.nextLong();
            sc.nextLine();

            list.add(new NhanVien(ten, c, t));
        }

        list.sort((a, b) -> {
            if (a.c != b.c) return b.c - a.c;
            if (a.t != b.t) return Long.compare(a.t, b.t);
            else return a.ten.compareTo(b.ten);
        });

        for (NhanVien item : list) {
            System.out.println(item);
        }
    }
}