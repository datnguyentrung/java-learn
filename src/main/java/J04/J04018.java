package J04;

import java.util.Scanner;

public class J04018 {
    static class SoPhuc{
        int thuc, ao;

        public SoPhuc(int thuc, int ao) {
            this.thuc = thuc;
            this.ao = ao;
        }

        public SoPhuc mul(SoPhuc other){
            return new SoPhuc(
                    this.thuc*other.thuc - this.ao*other.ao,
                    this.thuc*other.ao + this.ao*other.thuc
            );
        }

        public SoPhuc add(SoPhuc other){
            return new SoPhuc(
                    this.thuc + other.thuc,
                    this.ao + other.ao
            );
        }

        @Override
        public String toString() {
            if (ao < 0) {
                return thuc + " - " + (-ao) + "i";
            }
            return thuc + " + " + ao + "i";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            SoPhuc a = new SoPhuc(sc.nextInt(), sc.nextInt());
            SoPhuc b = new SoPhuc(sc.nextInt(), sc.nextInt());

            System.out.print( a.add(b).mul(a) + ", ");
            System.out.println( a.add(b).mul(a.add(b)));
        }
    }
}
