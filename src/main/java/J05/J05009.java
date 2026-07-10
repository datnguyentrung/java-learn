package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05009 {
    static int stt = 1;

    static class ThiSinh{
        int ma;
        String ten, ngaySinh;
        float diem;

        public ThiSinh(String ten, String ngaySinh, float d1, float d2, float d3) {
            this.ma = stt++;
            this.ten = ten;
            this.ngaySinh = ngaySinh;
            this.diem = d1 + d2 + d3;
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+ngaySinh+" "+diem;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        List<ThiSinh> thiSinhs = new ArrayList<>();
        while(t-- > 0 ){
            thiSinhs.add( new ThiSinh(
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextFloat(),
                    sc.nextFloat(),
                    sc.nextFloat()
            ));
            sc.nextLine();
        }

        List<ThiSinh> res = new ArrayList<>();
        float maxDiem = -1;
        for (ThiSinh thiSinh : thiSinhs){
            if (maxDiem < thiSinh.diem){
                res.clear();
                res.add(thiSinh);
                maxDiem = thiSinh.diem;
            }
            else if (maxDiem == thiSinh.diem) res.add(thiSinh);
            else break;
        }

        for (ThiSinh thiSinh : res){
            System.out.println(thiSinh);
        }
    }
}
