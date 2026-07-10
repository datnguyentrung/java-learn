package J03;

import java.util.*;

public class J03029 {
    static boolean checkS(String s) {
        if (s == null || s.isEmpty()) return false;
        char c = s.charAt(s.length() - 1);
        return c == '.' || c == '!' || c == '?';
    }

    static boolean isPunctuation(String s) {
        return s.equals(".") || s.equals("!") || s.equals("?");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> res = new ArrayList<>();

        while (sc.hasNextLine()){
            String line = sc.nextLine();
            StringBuilder s = new StringBuilder();

            Scanner ss = new Scanner(line);
            boolean tuDauTien = true;

            while (ss.hasNext()){
                String tu = ss.next().toLowerCase();
                boolean ketThucCau = checkS(tu);

                if (isPunctuation(tu)){
                    if (s.length() > 0 && s.charAt(s.length()-1) == ' '){
                        s.deleteCharAt(s.length()-1);
                    }

                    s.append(tu);
                    res.add(s.toString());
                    s.setLength(0);
                    tuDauTien = true;
                }
                else if (ketThucCau){
                    s.append(tu);

                    res.add(s.toString());
                    s.setLength(0);
                    tuDauTien = true;
                } else {
                    if (tuDauTien) {
                        tu = Character.toUpperCase(tu.charAt(0)) + tu.substring(1);
                        tuDauTien = false;
                    }
                    if (!ss.hasNext()){
                        tu += ".";
                    } else tu += " ";

                    s.append(tu);
                }
            }

            if (s.length() > 0) {
                res.add(s.toString());
            }
        }

        for (String line : res){
            System.out.println(line);
        }
    }
}
