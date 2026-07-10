package J04;

import java.util.*;

public class J04022 {
    static class WordSet{
        String line;
        String[] list;
        TreeSet<String> treeSet;

        public WordSet(String line) {
            this.line = line;
            this.list = line.trim().toLowerCase().split("\\s+");
            this.treeSet = new TreeSet<>(Arrays.asList(this.list));
        }

        public WordSet union(WordSet other){
            Set<String> res = new TreeSet<>(treeSet);

            res.addAll(other.treeSet);
            return new WordSet(String.join(" ", res));
        }

        public WordSet intersection(WordSet other){
            Set<String> res = new TreeSet<>(treeSet);

            res.retainAll(other.treeSet);
            return new WordSet(String.join(" ", res));
        }

        @Override
        public String toString(){
            return line;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
