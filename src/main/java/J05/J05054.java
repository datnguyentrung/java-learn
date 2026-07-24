package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05054 { // XẾP HẠNG HỌC SINH
    static int stt = 1;

    static class HocSinh {
        String ten, id, xepLoai;
        double dtb;
        int xepHang;

        public HocSinh(String ten, double dtb) {
            this.id = String.format("HS%02d", stt++);
            this.ten = ten;
            this.dtb = dtb;
            this.xepLoai = xepLoai();
        }

        public String xepLoai(){
            if (dtb < 5) return "Yeu";
            else if (dtb <7) {
                return "Trung Binh";
            } else if (dtb < 9){
                return "Kha";
            } else return "Gioi";
        }

        @Override
        public String toString() {
            return id + " " + ten + " "
                    + String.format("%.1f", dtb) + " "
                    + xepLoai + " " + xepHang;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<HocSinh> list = new ArrayList<>();

        while (t-- > 0) {
            list.add(new HocSinh(
                    sc.nextLine(),
                    Double.parseDouble(sc.nextLine())
            ));
        }

        List<HocSinh> sortedList = new ArrayList<>(list);

        sortedList.sort((a, b) -> Double.compare(b.dtb, a.dtb));

        for (int i = 0; i < sortedList.size(); i++){
            if (i==0){
                sortedList.get(i).xepHang = 1;
            } else if (Double.compare(sortedList.get(i).dtb, sortedList.get(i-1).dtb) == 0){
                sortedList.get(i).xepHang = sortedList.get(i-1).xepHang;
            } else sortedList.get(i).xepHang = i + 1;
        }

        for (HocSinh item : list) {
            System.out.println(item);
        }
    }
}