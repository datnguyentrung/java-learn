package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05033 {
    static class ThoiGian {
        int gio, phut, giay;
        String soSanh;

        public ThoiGian(int gio, int phut, int giay) {
            this.gio = gio;
            this.phut = phut;
            this.giay = giay;

            this.soSanh = String.format("%02d%02d%02d", gio, phut, giay);
        }

        @Override
        public String toString(){
            return gio+" "+phut+" "+giay;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<ThoiGian> list = new ArrayList<>();

        while (t-- > 0) {
            list.add(new ThoiGian(
                    sc.nextInt(), sc.nextInt(), sc.nextInt()
            ));
        }

        list.sort((a, b) -> {
            return a.soSanh.compareTo(b.soSanh);
        });

        for (ThoiGian item : list) {
            System.out.println(item);
        }


    }
}