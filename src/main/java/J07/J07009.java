package J07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class J07009 {
    static class IntSet {
        int [] arr;
        TreeSet<Integer> treeSet;

        public IntSet(int[] arr) {
            this.arr = arr;
            this.treeSet = new TreeSet<>();

            for (int value : arr) {
                this.treeSet.add(value);
            }
        }

        public IntSet intersection (IntSet other){
            Set<Integer> set = new TreeSet<>(this.treeSet);
            set.retainAll(other.treeSet);

            int[] result = set.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            return new IntSet(result);
        }

        @Override
        public String toString (){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++){
                if (i > 0) sb.append(" ");
                sb.append(arr[i]);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
}
