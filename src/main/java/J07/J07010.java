package J07;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class J07010 {
    static int stt = 1;

    static class SV {
        String ma, ten, lop, sinh;
        double diem;

        public SV(String ten, String lop, String sinh, double diem) {
            this.ma = String.format("B20DCCN%03d", stt++);

            this.ten = ten;
            this.lop = lop;
            this.sinh = chuanHoaNgay(sinh);
            this.diem = diem;
        }

        public String chuanHoaNgay(String s) {
            String[] line = s.trim().split("/");
            return String.format("%02d/%02d/%04d",
                    Integer.parseInt(line[0]),
                    Integer.parseInt(line[1]),
                    Integer.parseInt(line[2])
                    );
        }

        @Override
        public String toString() {
            return ma+" "+ten+" "+lop+" "+sinh+" "+String.format("%.02f", diem);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("SV.in"));

        int t = Integer.parseInt(sc.nextLine());
        List<SV> list = new ArrayList<>();

        while (t-->0) {
            list.add(new SV(
                    sc.nextLine(), sc.nextLine(), sc.nextLine(),
                    Double.parseDouble(sc.nextLine())
            ));
        }

        for (SV item : list) {
            System.out.println(item);
        }
    }
}
