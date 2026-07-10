package J03;

import java.util.*;

public class J03010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> mp = new HashMap<>();

        while (t-- > 0){
            String line = sc.nextLine();
            String[] splitLine = line.trim().split("\\s+");

            StringBuilder res = new StringBuilder();

            res.append(splitLine[splitLine.length-1].toLowerCase());
            for (int i = 0; i <= splitLine.length-2; i++){
                res.append(Character.toLowerCase(splitLine[i].charAt(0)));
            }

            if (mp.get(res.toString()) != null){
                mp.put(res.toString(), mp.get(res.toString()) + 1);

                res.append(mp.get(res.toString()));
            } else {
                mp.put(res.toString(), 1);
            }

            res.append("@ptit.edu.vn");

            System.out.println(res);
        }
    }
}
