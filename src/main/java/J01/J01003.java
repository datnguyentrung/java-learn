package J01;

import java.util.Scanner;

public class J01003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble(), b = sc.nextDouble();

        if (a == 0 && b == 0){
            System.out.println("VSN");
        } else if (a == 0){
            System.out.println("VN");
        } else {
            System.out.printf("%.2f%n", -b/a);
        }


    }
}
