package J02;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class J02007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 1; i <= t; i++){
            int n = sc.nextInt();

            Map<Integer, Integer> mp = new LinkedHashMap<>();

            while (n-->0){
                mp.merge(sc.nextInt(), 1, Integer::sum);
            }

            System.out.println("Test " + i + ":");
            for (Map.Entry<Integer, Integer> entry : mp.entrySet()){
                System.out.println(entry.getKey() + " xuat hien " + entry.getValue() + " lan");
            }
        }
    }
}
