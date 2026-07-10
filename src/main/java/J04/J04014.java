package J04;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

public class J04014 {
    static class PhanSo{
        private BigInteger tu, mau;

        public PhanSo(BigInteger tu, BigInteger mau) {
            this.tu = tu;
            this.mau = mau;
        }

        public void toiGian(){
            BigInteger gcd = this.tu.gcd(this.mau);
            this.tu = this.tu.divide(gcd);
            this.mau = this.mau.divide(gcd);
        }

        public PhanSo plus(PhanSo other){
            PhanSo moi = new PhanSo(
                    this.tu.multiply(other.mau).add(other.tu.multiply(this.mau)),
                    this.mau.multiply(other.mau)
            );
            moi.toiGian();
            return moi;
        }

        public PhanSo mul(PhanSo other){
            PhanSo moi = new PhanSo(
                    this.tu.multiply(other.tu),
                    this.mau.multiply(other.mau)
            );
            moi.toiGian();
            return moi;
        }

        @Override
        public String toString(){
            return tu+"/"+mau;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0){
            PhanSo a = new PhanSo(sc.nextBigInteger(), sc.nextBigInteger());
            PhanSo b = new PhanSo(sc.nextBigInteger(), sc.nextBigInteger());

            PhanSo c = a.plus(b).mul(a.plus(b));
            System.out.print(c + " ");
            System.out.println(a.mul(b.mul(c)));
        }
    }
}
