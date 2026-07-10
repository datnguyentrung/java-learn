package J03;

import java.util.*;

public class J03022 {
    public static boolean isEnd(String s) {
        char c = s.charAt(s.length() - 1);
        return c == '.' || c == '?' || c == '!';
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> res = new ArrayList<>();
        List<String> cau = new ArrayList<>();
        while (sc.hasNext()){
            String tu = sc.next();
            if (isEnd(tu)){
                tu = tu.substring(0, tu.length() - 1);
                cau.add(tu);

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < cau.size(); i++) {
                    String word = cau.get(i).toLowerCase();

                    if (i == 0) {
                        sb.append(Character.toUpperCase(word.charAt(0)))
                                .append(word.substring(1));
                    } else {
                        sb.append(" ").append(word);
                    }
                }

                res.add(sb.toString());
                cau.clear();
            } else {
                cau.add(tu);
            }
        }

        for (String s : res){
            System.out.println(s);
        }

        sc.close();
    }
}
