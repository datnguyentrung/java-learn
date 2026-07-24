package test;

import java.math.BigInteger;
import java.util.Scanner;

public class B4 {
    static class PhanSo{
        BigInteger tu, mau;

        public PhanSo(BigInteger tu, BigInteger mau) {
            this.tu = tu;
            this.mau = mau;
        }

        public void toiGian(){
            BigInteger gcd = tu.gcd(mau);

            tu = tu.divide(gcd);
            mau = mau.divide(gcd);
        }

        public PhanSo cong (PhanSo other){
            BigInteger tu = this.tu.multiply(other.mau).add(other.tu.multiply(this.mau));
            BigInteger mau = this.mau.multiply(other.mau);

            PhanSo phanSo = new PhanSo(tu, mau);
            phanSo.toiGian();
            return phanSo;
        }

        @Override
        public String toString(){
            return tu + "/" + mau;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PhanSo a = new PhanSo(sc.nextBigInteger(), sc.nextBigInteger());
        PhanSo b = new PhanSo(sc.nextBigInteger(), sc.nextBigInteger());

        System.out.println(a.cong(b));
    }
}
