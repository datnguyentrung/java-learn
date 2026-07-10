package J04;

import java.math.BigInteger;
import java.util.Scanner;

public class J04004 {
    static class PhanSo{
        BigInteger a, b;

        public PhanSo(BigInteger a, BigInteger b) {
            this.a = a;
            this.b = b;
        }

        public PhanSo dividePS(PhanSo other){
            BigInteger tu = this.a.multiply(other.b)
                    .add(other.a.multiply(this.b));

            BigInteger mau = this.b.multiply(other.b);

            BigInteger c = tu.gcd(mau);
            return new PhanSo(
                    tu.divide(c),
                    mau.divide(c)
            );
        }

        @Override
        public String toString(){
            return a + "/" + b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PhanSo a = new PhanSo(sc.nextBigInteger(), sc.nextBigInteger());
        PhanSo b = new PhanSo(sc.nextBigInteger(), sc.nextBigInteger());

        System.out.println(a.dividePS(b));
    }
}
