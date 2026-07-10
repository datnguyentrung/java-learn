package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05011 {
    static class Game{
        String ma, ten, in, out;
        String duration;
        int gio, phut;

        public Game(String ma, String ten, String in, String out) {
            this.ma = ma;
            this.ten = ten;
            this.in = in;
            this.out = out;
            this.duration = duration(in, out);
        }

        public int thoiGian(String s){
            String[] strings = s.trim().split(":");
            return Integer.parseInt(strings[0]) * 60 + Integer.parseInt(strings[1]);
        }

        public String duration(String in, String out){
            int thoiGian = thoiGian(out) - thoiGian(in);
            this.gio = thoiGian / 60;
            this.phut = thoiGian % 60;

            return gio + " gio " + phut + " phut";
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+duration;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<Game> games = new ArrayList<>();

        while(t-- > 0){
            games.add(new Game(
                    sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()
            ));
        }

        games.sort((a, b) -> {
            if (a.gio == b.gio) return b.phut - a.phut;
            return b.gio - a.gio;
        });

        for (Game game : games){
            System.out.println(game);
        }
    }
}
