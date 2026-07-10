package J04;

import java.util.*;

public class J04021 {
    static class IntSet{
        int[] arr;

        public IntSet(int[] arr) {
            this.arr = arr;
        }

        public IntSet union(IntSet other){
            Set<Integer> res = new TreeSet<>();

            for (int x : this.arr) res.add(x);
            for (int x : other.arr) res.add(x);

            int[] newArr = new int[res.size()];
            int i = 0;
            for (int x : res){
                newArr[i++] = x;
            }

            return new IntSet(newArr);
        }

        @Override
        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            for (int x : this.arr){
                stringBuilder.append(x).append(" ");
            }
            return stringBuilder.toString().trim();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
}
