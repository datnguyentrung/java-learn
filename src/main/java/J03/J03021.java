package J03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J03021 {
    public static boolean checkS(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        Map<Character, Integer> mp = new HashMap<>();
        mp.put('A', 2);
        mp.put('B', 2);
        mp.put('C', 2);
        mp.put('D', 3);
        mp.put('E', 3);
        mp.put('F', 3);
        mp.put('G', 4);
        mp.put('H', 4);
        mp.put('I', 4);
        mp.put('J', 5);
        mp.put('K', 5);
        mp.put('L', 5);
        mp.put('M', 6);
        mp.put('N', 6);
        mp.put('O', 6);
        mp.put('P', 7);
        mp.put('Q', 7);
        mp.put('R', 7);
        mp.put('S', 7);
        mp.put('T', 8);
        mp.put('U', 8);
        mp.put('V', 8);
        mp.put('W', 9);
        mp.put('X', 9);
        mp.put('Y', 9);
        mp.put('Z', 9);
        
        while(t-- > 0){
            String line = sc.nextLine().toUpperCase();
            
            StringBuilder res = new StringBuilder();
            
            for (Character c : line.toCharArray()){
                res.append(mp.get(c).toString());
            }

            if (checkS(res.toString())) System.out.println("YES");
            else System.out.println("NO");
        }

        sc.close();
    }
}
