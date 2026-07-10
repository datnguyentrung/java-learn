package J03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J03036 {
    static int cost(String s, String target){
        return (s + s).indexOf(target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        List<String> list = new ArrayList<>();
        while (t-- > 0){
            list.add(sc.next());
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++){
            int curr = 0;
            for (int j = 0; j < list.size(); j++){
                if (i == j) continue;

                int costN = cost(list.get(j), list.get(i));
                if (costN < 0){
                    System.out.println("-1");
                    return;
                }
                curr += costN;
            }
            res = Math.min(res, curr);
        }

        System.out.println(res == Integer.MAX_VALUE ? "-1" : res);
    }
}
