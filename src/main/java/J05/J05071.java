package J05;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class J05071 { // TÍNH CƯỚC ĐIỆN THOẠI CỐ ĐỊNH - 1
    static class Tinh {
        Integer maVung, gia;
        String ten;

        public Tinh(Integer maVung, String ten, int gia) {
            this.maVung = maVung;
            this.ten = ten;
            this.gia = gia;
        }

        public Tinh() {
        }
    }

    static class CuocGoi {
        String thueBao, batDau, ketThuc;
        Tinh tinh;
        int thoiGian, giaCuoc;

        public CuocGoi(String thueBao, String batDau, String ketThuc, Tinh tinh) {
            this.thueBao = thueBao;
            this.batDau = batDau;
            this.ketThuc = ketThuc;
            this.tinh = tinh;

            int soPhut = duration();

            thoiGian = tinh.ten.equals("Noi mang")
                    ? (int) Math.ceil(soPhut / 3.0)
                    : soPhut;
            this.giaCuoc = thoiGian*tinh.gia;
        }

        public int duration() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            LocalTime st = LocalTime.parse(batDau, formatter);
            LocalTime en = LocalTime.parse(ketThuc, formatter);

            Duration duration = Duration.between(st, en);

            if (duration.isNegative()) {
                duration = duration.plusDays(1);
            }

            return (int) duration.toMinutes();
        }

        @Override
        public String toString(){
            return thueBao+" "+tinh.ten+" "+thoiGian+" "+giaCuoc;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        List<Tinh> list1 = new ArrayList<>();

        Tinh noiMang = new Tinh(
                null , "Noi mang", 800
        );

        while(t-->0){
            list1.add( new Tinh(
                    Integer.parseInt(sc.nextLine()),
                    sc.nextLine(),
                    Integer.parseInt(sc.nextLine())
            ));
        }

        int m = Integer.parseInt(sc.nextLine());

        List<CuocGoi> list2 = new ArrayList<>();

        while (m-->0) {
            String[] line = sc.nextLine().trim().split("\\s+");

            Tinh tinh;

            if (!line[0].startsWith("0")) {
                tinh = noiMang;
            } else {
                int ma = Integer.parseInt(line[0].substring(1, 3));
                tinh = null;

                for (Tinh tinh1 : list1) {
                    if (tinh1.maVung == ma) {
                        tinh = tinh1;
                        break;
                    }
                }
            }

            list2.add( new CuocGoi(
                    line[0], line[1], line[2], tinh
            ));
        }

        for (CuocGoi cuocGoi : list2) {
            System.out.println(cuocGoi);
        }
    }
}