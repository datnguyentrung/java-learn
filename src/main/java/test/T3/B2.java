package test.T3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B2 {
    static List<Truong> truongs = new ArrayList<>();
    static int stt = 1;

    static class Truong {
        String ma, ten;

        public Truong(String line) {
            String[] splitLine = line.trim().split("\\s+");

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < splitLine.length; i++){
                if (i > 1) sb.append(" ");
                sb.append(splitLine[i]);
            }

            this.ma = splitLine[0];
            this.ten = sb.toString();
        }
    }

    static class DangKy {
        Truong t;
        String tenDoi;

        public DangKy(String maTruonng, String tenDoi) {
            for (Truong truong : truongs) {
                if (truong.ma.equals(maTruonng)) {
                    this.t = truong;
                    break;
                }
            }

            this.tenDoi = tenDoi.trim();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("INSTITUTION.in"));
        Scanner sc2 = new Scanner(new File("REGISTER.in"));

        int n = Integer.parseInt(sc1.nextLine());
        while (n-->0) {
            truongs.add(new Truong(sc1.nextLine()));
        }

        n = Integer.parseInt(sc2.nextLine());

        List<DangKy> dangKIES = new ArrayList<>();
        while (n-->0) {
            String line = sc2.nextLine();
            String[] splitLine = line.trim().split("\\s+");
            int doi = Integer.parseInt(splitLine[1]);

            while (doi-->0) {
                dangKIES.add(new DangKy(splitLine[0], sc2.nextLine()));
            }
        }

        dangKIES.sort((a, b) ->{
            if (a.t.ten.equals(b.t.ten)) return a.tenDoi.compareTo(b.tenDoi);
            return a.t.ten.compareTo(b.t.ten);
        });

        for (DangKy dangKy : dangKIES) {
            String maDangKy = String.format("team%02d", stt++);
            System.out.println(maDangKy+" "+dangKy.tenDoi+" "+dangKy.t.ten);
        }
    }
}
