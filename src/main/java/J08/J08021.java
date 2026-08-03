package J08;

import java.util.Scanner;
import java.util.Stack;

public class J08021 {
    static int longestValid(String s) {
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {

                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            System.out.println(longestValid(sc.nextLine()));
        }
    }
}
