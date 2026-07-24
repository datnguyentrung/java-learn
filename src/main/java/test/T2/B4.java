package test.T2;

import java.util.Scanner;

public class B4 {
    static int sma = 1;

    static class NguoiCong {
        String ma, hoVaTen, dienThoai;
        int namSinh;
        double hsl;

        public void input(Scanner scanner) {
            this.ma = String.format("E%03d", sma++);

            this.hoVaTen = scanner.nextLine();
            this.namSinh = Integer.parseInt(scanner.nextLine());
            this.hsl = Double.parseDouble(scanner.nextLine())*10000;
            this.dienThoai = scanner.nextLine();
        }

        public String getMa(){
            return ma;
        }

        public int getTuoi(){
            return 2026 - namSinh;
        }

        @Override
        public String toString(){
            return ma+" "+hoVaTen+" "+getTuoi()+" "+dienThoai+" "+hsl;
        }
    }

    static class QLNC {
        NguoiCong[] ds;

        public QLNC(NguoiCong[] a) {
            this.ds = a;
        }

        public void out(){
            for (NguoiCong a : ds){
                System.out.println(a);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        NguoiCong[] ds = new NguoiCong[n];
        for (int i = 0; i < n; i++){
            ds[i] = new NguoiCong();
            ds[i].input(sc);
        }
        QLNC ql = new QLNC(ds);
        ql.out();
    }
}
