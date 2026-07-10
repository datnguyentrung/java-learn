package J04;

import java.math.BigInteger;
import java.util.Scanner;

public class J04005 {
    static class ThiSinh{
        String ten, sinh;
        float diem;

        public ThiSinh(String ten, String sinh, float d1, float d2, float d3) {
            this.ten = ten;
            this.sinh = sinh;
            this.diem = d1+d2+d3;
        }

        @Override
        public String toString(){
            return ten + " " + sinh + " " + diem;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new ThiSinh(
                sc.nextLine(), sc.nextLine(), sc.nextFloat(), sc.nextFloat(), sc.nextFloat()
        ));
    }
}
