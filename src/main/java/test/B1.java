package test;

import java.util.*;

public class B1 {
    static class MonHoc{
        String ma, ten;

        public MonHoc(String ma, String ten) {
            this.ma = ma;
            this.ten = ten;
        }
    }

    static class GiangVien{
        String ma, ten;

        public GiangVien(String ma, String ten) {
            this.ma = ma;
            this.ten = ten;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int soMonHoc = Integer.parseInt(sc.nextLine());

        List<MonHoc> monHocs = new ArrayList<>();
        while (soMonHoc-->0){
            String[] line = sc.nextLine().trim().split("\\s+");
            String maMonHoc = line[0];
            StringBuilder ten = new StringBuilder();
            for (int i = 1; i < line.length; i++) ten.append(line[i]).append(" ");
            ten.deleteCharAt(ten.length()-1);

            monHocs.add(new MonHoc(
                    maMonHoc, ten.toString()
            ));
        }

        List<GiangVien> giangViens = new ArrayList<>();
        int soGiangVien = Integer.parseInt(sc.nextLine());
        while (soGiangVien-->0){
            String[] line = sc.nextLine().trim().split("\\s+");
            String maGV = line[0];
            StringBuilder ten = new StringBuilder();
            for (int i = 1; i < line.length; i++) ten.append(line[i]).append(" ");
            ten.deleteCharAt(ten.length()-1);

            giangViens.add(new GiangVien(maGV, ten.toString()));
        }

        Map<String, Double> ans = new LinkedHashMap<>();
        int soLHP = Integer.parseInt(sc.nextLine());
        while (soLHP-->0){
            String[] line = sc.nextLine().trim().split("\\s+");

            ans.merge(line[0], Double.parseDouble(line[2]), Double::sum);
        }

        for (Map.Entry<String, Double> entry : ans.entrySet()){
            for (GiangVien gv : giangViens){
                if (gv.ma.equals(entry.getKey())) {
                    System.out.print(gv.ten + " ");
                }
            }
            System.out.printf("%.02f%n", entry.getValue());
        }
    }
}
