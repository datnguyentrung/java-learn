package J03;

import java.util.*;

public class J03009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0){
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();
            String[] splitLine1 = line1.trim().split("\\s+");
            String[] splitLine2 = line2.trim().split("\\s+");

            Set<String> set1 = new TreeSet<>(Arrays.asList(splitLine1));
            Set<String> set2 = new TreeSet<>(Arrays.asList(splitLine2));
            set1.removeAll(set2);

            for (String s : set1){
                System.out.print(s + " ");
            }

            System.out.println();
        }
    }
}
