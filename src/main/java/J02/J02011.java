package J02;

import java.util.Scanner;

public class J02011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n-1; i++){
            int pos = i;
            int minN = arr[i];

            for (int j = i + 1; j < n; j++){
                if (minN > arr[j]){
                    minN = arr[j];
                    pos = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;

            System.out.print("Buoc " + (i+1) + ":");
            for (int x : arr) System.out.print(" " + x);
            System.out.println();
        }


    }
}
