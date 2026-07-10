package J01;

import java.util.Scanner;

public class J01005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();

            double h = sc.nextDouble();

            for (int i = 1; i < n; i++){
                double ans = h * Math.sqrt((double) i / n);

                System.out.printf("%.6f ", ans);

                if (i < n-1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
