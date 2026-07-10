package J03.J03017;

import java.util.*;

public class J03017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0){
            String line = sc.nextLine();

            Stack<Node> stack = new Stack<>();
            List<Integer> list = new ArrayList<>(Collections.nCopies(line.length(), 0));

            for (int i = 0; i < line.length(); i++){
                stack.add(new Node(line.charAt(i), i));

                if (stack.size() >= 3){
                    int n = stack.size();

                    if (stack.get(n-3).getN() == '1'
                        && stack.get(n-2).getN() == '0'
                            && stack.get(n-1).getN() == '0'
                    ){
                        Node c = stack.pop();
                        Node b = stack.pop();
                        Node a = stack.pop();

                        list.set(c.getStt(), 1);
                        list.set(b.getStt(), 1);
                        list.set(a.getStt(), 1);
                    }
                }
            }

            int cnt = 0, res = 0;
            for (Integer integer : list){
                if (integer == 1){
                    cnt ++;
                    res = Math.max(cnt, res);
                } else cnt = 0;
            }

            System.out.println(res);
        }

        sc.close();
    }
}
