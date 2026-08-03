package J05;

import java.util.*;

public class J05075 { // TÍNH CƯỚC ĐIỆN THOẠI CỐ ĐỊNH - 1
    static class SinhVien {
        String ma, ten, lop, diemDanh, note;
        int diem = 10;

        public SinhVien(String ma, String ten, String lop) {
            this.ma = ma;
            this.ten = ten;
            this.lop = lop;
        }

        public void setDiem(){
            for (char c : diemDanh.toCharArray()){
                if (c=='v') diem -= 2;
                else if (c=='m') diem -= 1;
            }
            if (diem <= 0) {
                note = "KDDK";
                diem = 0;
            }
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+lop+" "+diem+" "+(diem==0 ? note : "");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        Map<String, SinhVien> map = new LinkedHashMap<>();

        for (int i = 0; i < t; i++){
            SinhVien sv = new SinhVien(
                    sc.nextLine(), sc.nextLine(), sc.nextLine()
            );
            map.put(sv.ma, sv);
        }

        for (int i = 0; i < t; i++){
            String[] line = sc.nextLine().trim().split("\\s+");
            map.get(line[0]).diemDanh = line[1];
            map.get(line[0]).setDiem();
        }

        List<SinhVien> list = new ArrayList<>();
        for (Map.Entry<String, SinhVien> entry : map.entrySet()) {
            list.add(entry.getValue());
        }

        for (SinhVien item : list) {
            System.out.println(item);
        }
    }
}