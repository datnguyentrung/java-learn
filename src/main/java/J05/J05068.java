package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05068 { // QUẢN LÝ KHO XĂNG DẦU

    static class CLB {
        String maCLB, ten;
        int gia;

        public CLB(String maCLB, String ten, int gia) {
            this.maCLB = maCLB;
            this.ten = ten;
            this.gia = gia;
        }
    }

    static class TranDau {
        String ma;
        String maCLB;
        String ten;
        long cdv;
        long doanhThu;

        public TranDau(String ma, long cdv) {
            this.ma = ma;
            this.maCLB = ma.substring(1, 3);
            this.cdv = cdv;
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + doanhThu;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        List<CLB> danhSachCLB = new ArrayList<>();

        while (t-- > 0) {
            danhSachCLB.add(new CLB(
                    sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())
            ));
        }

        int m = Integer.parseInt(sc.nextLine());
        List<TranDau> danhSachTran = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String maTran = sc.next();
            long soCDV = sc.nextLong();

            TranDau tranDau = new TranDau(maTran, soCDV);

            for (CLB clb : danhSachCLB) {
                if (tranDau.maCLB.equals(clb.maCLB)) {
                    tranDau.ten = clb.ten;
                    tranDau.doanhThu = tranDau.cdv * clb.gia;
                    break;
                }
            }

            danhSachTran.add(tranDau);
        }

        danhSachTran.sort((a, b) -> {
            if (a.doanhThu != b.doanhThu) {
                return Long.compare(b.doanhThu, a.doanhThu);
            }

            return a.ten.compareTo(b.ten);
        });

        for (TranDau tranDau : danhSachTran) {
            System.out.println(tranDau);
        }
    }
}