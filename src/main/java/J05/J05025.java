package J05;

import java.util.*;

public class J05025 {
    static int stt = 1;

    static class GiangVien{
        String ma, fullName, ten, nganh;

        public GiangVien(String fullName, String nganh) {
            this.ma = chuanHoaMa();
            this.fullName = fullName;
            this.ten = layTen(fullName);
            this.nganh = chuanHoaNganh(nganh);
        }

        public String layTen(String fullName){
            String[] strings = fullName.trim().split("\\s+");
            return strings[strings.length-1];
        }

        public String chuanHoaMa(){
            StringBuilder sb = new StringBuilder("GV");
            if (stt < 10) sb.append("0");
            sb.append(stt++);
            return sb.toString();
        }

        public String chuanHoaNganh(String s){
            String[] strings = s.trim().split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (String tu : strings){
                sb.append(Character.toUpperCase(tu.charAt(0)));
            }
            return sb.toString();
        }

        @Override
        public String toString(){
            return ma+" "+fullName+" "+nganh;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<GiangVien> giangViens = new ArrayList<>();

        while (t-- > 0){
            giangViens.add(new GiangVien(sc.nextLine(), sc.nextLine()));
        }

        giangViens.sort((a, b) -> {
            if (a.ten.equals(b.ten)) return a.ma.compareTo(b.ma);
            return a.ten.compareTo(b.ten);
        });

        for (GiangVien gv : giangViens){
            System.out.println(gv);
        }
    }
}