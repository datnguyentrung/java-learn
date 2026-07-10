package J02;

import java.util.*;

public class J02034 { // BỔ SUNG DÃY SỐ
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();

        while (sc.hasNext()){
            int x = sc.nextInt();
            a.add(x);
            mp.put(x, 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < a.get(n-1); i++){
            if (mp.get(i) == null) res.add(i);
        }

        if (res.isEmpty()) System.out.println("Excellent!");
        else for (int x : res) System.out.println(x);
    }
}