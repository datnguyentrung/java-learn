package J03;

import java.util.Scanner;
import java.util.Stack;

public class J03027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        for (Character c : line.toCharArray()){
            stack.add(c);

            while(stack.size() >= 2){
                int len = stack.size();
                if (stack.get(len-1).equals(stack.get(len-2))){
                    stack.pop();
                    stack.pop();
                } else break;
            }
        }

        if (stack.isEmpty()) System.out.println("Empty String");
        else {
            StringBuilder stringBuilder = new StringBuilder();

            for (char c : stack){
                stringBuilder.append(c);
            }

            System.out.println(stringBuilder);
        }
    }
}
