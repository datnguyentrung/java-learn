package J05;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05056 { // XẾP HẠNG HỌC SINH
    static int stt = 1;

    static class VDV {
        String ten, sinh, xp, dich, ma, thanhTichThucTe, uuTien, thanhTichXepHang;
        int xepHang;

        public VDV(String ten, String sinh, String xp, String dich) {
            this.ma = String.format("VDV%02d", stt++);
            this.ten = ten;
            this.sinh = sinh;
            this.xp = xp;
            this.dich = dich;

            this.thanhTichThucTe = getThanhTichThucTe();
            this.uuTien = getUuTien();
            this.thanhTichXepHang = getThanhTichXepHang();
        }

        public String getThanhTichThucTe() {
            LocalTime start = LocalTime.parse(xp);
            LocalTime end = LocalTime.parse(dich);

            long seconds = Duration.between(start, end).getSeconds();

            return formatTime(seconds);
        }

        public String getUuTien() {
            int namSinh = Integer.parseInt(sinh.substring(6));
            int tuoi = 2021 - namSinh;

            int soGiayUuTien;

            if (tuoi < 18) {
                soGiayUuTien = 0;
            } else if (tuoi < 25) {
                soGiayUuTien = 1;
            } else if (tuoi < 32) {
                soGiayUuTien = 2;
            } else {
                soGiayUuTien = 3;
            }

            return String.format("00:00:%02d", soGiayUuTien);
        }

        public String getThanhTichXepHang() {
            LocalTime thucTe = LocalTime.parse(thanhTichThucTe);
            LocalTime thoiGianUuTien = LocalTime.parse(uuTien);

            long soGiayThucTe = thucTe.toSecondOfDay();
            long soGiayUuTien = thoiGianUuTien.toSecondOfDay();

            return formatTime(soGiayThucTe - soGiayUuTien);
        }

        private String formatTime(long seconds) {
            long hours = seconds / 3600;
            long minutes = seconds % 3600 / 60;
            long secs = seconds % 60;

            return String.format(
                    "%02d:%02d:%02d",
                    hours,
                    minutes,
                    secs
            );
        }

        @Override
        public String toString() {
            return ma + " "
                    + ten + " "
                    + thanhTichThucTe + " "
                    + uuTien + " "
                    + thanhTichXepHang + " "
                    + xepHang;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<VDV> list = new ArrayList<>();

        while (t-- > 0) {
            list.add(new VDV(
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextLine()
            ));
        }

        List<VDV> sortedList = new ArrayList<>(list);

        sortedList.sort((a, b) -> a.thanhTichXepHang.compareTo(b.thanhTichXepHang));

        for (int i = 0; i < sortedList.size(); i++){
            if (i==0){
                sortedList.get(i).xepHang = 1;
            } else if (sortedList.get(i).thanhTichXepHang.compareTo(sortedList.get(i-1).thanhTichXepHang) == 0){
                sortedList.get(i).xepHang = sortedList.get(i-1).xepHang;
            } else sortedList.get(i).xepHang = i + 1;
        }

        for (VDV item : sortedList) {
            System.out.println(item);
        }
    }
}