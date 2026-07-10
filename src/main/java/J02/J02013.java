package J02;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class J02013 { // SẮP XẾP NỔI BỌT

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int cnt = 1;
        while (true){
            boolean check = true;
            for (int i = 0; i < n-1; i++){
                if (arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    check = false;
                }
            }

            if (check) break;

            System.out.print("Buoc " + cnt++ + ":");
            for (int i = 0; i < n; i++){
                System.out.print(" " + arr[i]);
            }
            System.out.println();
        }
    }
}
