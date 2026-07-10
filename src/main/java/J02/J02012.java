package J02;

import java.util.*;

public class J02012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> mp = new TreeMap<>();

        for (int i = 0; i < n; i++){
            mp.merge(arr[i], 1, Integer::sum);

            System.out.print("Buoc " + i + ":");
            for (Map.Entry<Integer, Integer>entry : mp.entrySet()){
                for (int j = 0; j < entry.getValue(); j++){
                    System.out.print(" " + entry.getKey());
                }
            }
            System.out.println();
        }
    }
}
