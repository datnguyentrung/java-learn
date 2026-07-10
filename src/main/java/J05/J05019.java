package J05;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class J05019 {
    static int stt = 1;

    static String chuanHoaMa() {
        StringBuilder sb = new StringBuilder("T");
        if (stt < 10) sb.append("0");
        sb.append(stt++);
        return sb.toString();
    }

    static long tinhSoPhut(String batDau, String ketThuc) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime st = LocalTime.parse(batDau.trim(), formatter);
        LocalTime en = LocalTime.parse(ketThuc.trim(), formatter);

        return ChronoUnit.MINUTES.between(st, en);
    }

    static class Tram {
        String ma, ten;
        double tongMua;
        long tongPhut;

        public Tram(String ten) {
            this.ma = chuanHoaMa();
            this.ten = ten;
            this.tongMua = 0;
            this.tongPhut = 0;
        }

        public void themLanDo(String batDau, String ketThuc, double mua) {
            this.tongMua += mua;
            this.tongPhut += tinhSoPhut(batDau, ketThuc);
        }

        public double getTb() {
            return tongMua / (tongPhut / 60.0);
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + String.format("%.2f", getTb());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        Map<String, Tram> mp = new LinkedHashMap<>();

        while (t-- > 0) {
            String ten = sc.nextLine().trim();
            String batDau = sc.nextLine().trim();
            String ketThuc = sc.nextLine().trim();
            double luongMua = sc.nextDouble();
            sc.nextLine();

            if (!mp.containsKey(ten)) {
                mp.put(ten, new Tram(ten));
            }

            mp.get(ten).themLanDo(batDau, ketThuc, luongMua);
        }

        for (Tram tram : mp.values()) {
            System.out.println(tram);
        }
    }
}