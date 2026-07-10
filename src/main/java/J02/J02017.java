package J02;

import java.util.Scanner;
import java.util.Stack;

public class J02017 { // THU GỌN DÃY SỐ

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++){
            st.add(sc.nextInt());

            while (st.size() > 1){
                int temp = st.pop();
                if ((temp + st.peek()) % 2 == 0) st.pop();
                else {
                    st.add(temp);
                    break;
                }
            }
        }

        System.out.println(st.size());
    }
}