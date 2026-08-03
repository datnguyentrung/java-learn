package J08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class J08020 {
    static boolean checkC (char c) {
        return c=='{' || c=='(' || c=='[';
    }

    static boolean checkS (String line) {
        Stack<Character> st = new Stack<>();
        for (char c : line.toCharArray()) {
            if (checkC(c)) st.add(c);

            else {
                if (st.isEmpty()) return false;

                char check = st.peek();

                if (c=='}' && check=='{') st.pop();
                else if (c==']' && check=='[') {
                    st.pop();
                } else if (c==')' && check=='(') {
                    st.pop();
                } else return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            if (checkS(sc.nextLine())) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
