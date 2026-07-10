package J05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05032 {
    static class Nguoi{
        String ten, sinh;

        public Nguoi(String ten, String sinh) {
            this.ten = ten;
            this.sinh = sinh;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Nguoi> list = new ArrayList<>();

        while (t-- > 0){
            list.add(new Nguoi(
                    sc.next(), sc.next()
            ));
            sc.nextLine();
        }

        list.sort((a, b) -> {
            LocalDate d1 = LocalDate.parse(a.sinh.trim(), formatter);
            LocalDate d2 = LocalDate.parse(b.sinh.trim(), formatter);

            return d2.compareTo(d1);
        });

        System.out.println(list.get(0).ten);
        System.out.println(list.get(list.size()-1).ten);
    }
}