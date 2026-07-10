package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05018 {
    static int stt = 1;

    static String chuanHoaMa() {
        StringBuilder sb = new StringBuilder("HS");
        if (stt < 10) sb.append("0");
        sb.append(stt++);
        return sb.toString();
    }

    static class HocSinh {
        String ma, ten;
        double dtb;

        public HocSinh(String ten, double dtb) {
            this.ma = chuanHoaMa();
            this.ten = ten;
            this.dtb = dtb;
        }

        public String ketQua() {
            if (dtb > 9) return "XUAT SAC";
            else if (dtb > 8) {
                return "GIOI";
            } else if (dtb > 7) {
                return "KHA";
            } else if (dtb > 5) {
                return "TB";
            } else {
                return "YEU";
            }
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+Math.round(dtb * 10.0) / 10.0+" "+ketQua();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<HocSinh> arrayList = new ArrayList<>();

        while (t-- > 0) {
            String ten = sc.nextLine();
            double sum = 0;
            for (int i = 0; i < 10; i++){
                double diem = sc.nextDouble();
                if (i == 0 || i == 1)  sum+= diem * 2;
                else  sum += diem;
            }

            arrayList.add(new HocSinh(
                    ten, sum /12
            ));

            sc.nextLine();
        }

        arrayList.sort((a, b) -> Double.compare(b.dtb, a.dtb));

        for (HocSinh item : arrayList) {
            System.out.println(item);
        }
    }
}