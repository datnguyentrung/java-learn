package test;

import java.util.*;

public class B3 {
    static boolean checkS(String s){
        char c = s.charAt(s.length() - 1);
        return c == '.' || c == '!' || c == '?';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> ans = new ArrayList<>();

        while (sc.hasNextLine()){
            String[] line = sc.nextLine().toLowerCase().trim().split("\\s+");
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < line.length; i++){
                String word = line[i];

                if (i == 0) sb.append(Character.toUpperCase(line[i].charAt(0)))
                        .append(line[i].substring(1));
                else if (word.length() == 1 && checkS(word)) {
                    sb.append(word);
                } else sb.append(" ").append(line[i]);

                if (checkS(line[i]) && i < line.length-1){
                    sb.append("\n");
                }

                if (i == line.length-1 && !checkS(word)) sb.append(".");
            }

            ans.add(sb.toString());
        }

        for (String s : ans) System.out.println(s);
    }
}
