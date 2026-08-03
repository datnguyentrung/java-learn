package J07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class J07008 {
    static int n;
    static int[] a;
    static List<Integer> curr = new ArrayList<>();
    static List<String> res = new ArrayList<>();

    static void backtrack(int st) {
        for (int i = st; i < n; i++){
            if (curr.isEmpty() || a[i] > curr.get(curr.size()-1)) {
                curr.add(a[i]);

                if (curr.size() >= 2){
                    StringBuilder sb = new StringBuilder();

                    for (int j = 0; j < curr.size(); j++) {
                        if (j > 0) sb.append(" ");
                        sb.append(curr.get(j));
                    }

                    res.add(sb.toString());
                }

                // Tiếp tục chọn các phần tử phía sau
                backtrack(i+1);

                // Quay lui
                curr.remove(curr.size()-1);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DAYSO.in"));

        n = sc.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        backtrack(0);

        Collections.sort(res);

        for (String s : res) System.out.println(s);
    }
}
