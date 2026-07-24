package test;

import java.util.*;

public class B2 {
    static class MonHoc {
        String ma, ten;

        public MonHoc(String ma, String ten) {
            this.ma = ma;
            this.ten = ten;
        }
    }

    static class DiemLHP {
        String maMH;
        Double diem;

        public DiemLHP(String maMH, Double diem) {
            this.maMH = maMH;
            this.diem = diem;
        }
    }

    static class GiangVien {
        String ma, ten;
        List<DiemLHP> lhp;

        public GiangVien(String ma, String ten) {
            this.ma = ma;
            this.ten = ten;
            this.lhp = new ArrayList<>();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int soMonHoc = Integer.parseInt(sc.nextLine());

        Map<String, MonHoc> monHocMap = new HashMap<>();
        while (soMonHoc-- > 0) {
            String[] line = sc.nextLine().trim().split("\\s+");
            String maMonHoc = line[0];
            StringBuilder ten = new StringBuilder();
            for (int i = 1; i < line.length; i++) ten.append(line[i]).append(" ");
            ten.deleteCharAt(ten.length() - 1);

            monHocMap.put(maMonHoc, new MonHoc(
                    maMonHoc, ten.toString()
            ));
        }

        Map<String, GiangVien> ans = new LinkedHashMap<>();
        int soGiangVien = Integer.parseInt(sc.nextLine());
        while (soGiangVien-- > 0) {
            String[] line = sc.nextLine().trim().split("\\s+");
            String maGV = line[0];
            StringBuilder ten = new StringBuilder();
            for (int i = 1; i < line.length; i++) ten.append(line[i]).append(" ");
            ten.deleteCharAt(ten.length() - 1);

            ans.put(maGV, new GiangVien(maGV, ten.toString()));
        }


        int soLHP = Integer.parseInt(sc.nextLine());
        while (soLHP-- > 0) {
            String[] line = sc.nextLine().trim().split("\\s+");
            String maGV = line[0];
            String maMH = line[1];
            Double diem = Double.parseDouble(line[2]);

            GiangVien giangVien = ans.get(maGV);
            giangVien.lhp.add(new DiemLHP(maMH, diem));
        }

        String search = sc.nextLine();

        GiangVien giangVien = ans.get(search);
        System.out.println("Giang vien: " + giangVien.ten);

        Double sum = (double) 0;
        for (DiemLHP diemLHP : giangVien.lhp) {
            sum += diemLHP.diem;
            System.out.println(monHocMap.get(diemLHP.maMH).ten + " " + diemLHP.diem);
        }

        System.out.printf("Tong: %.02f%n", sum);
    }
}
