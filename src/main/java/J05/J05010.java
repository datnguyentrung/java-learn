package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05010 {
    static int stt = 1;

    static class MatHang{
        int ma;
        String ten, nhom;
        double loiNhuan;

        public MatHang(String ten, String nhom, double mua, double ban) {
            this.ma = stt++;
            this.ten = ten;
            this.nhom = nhom;
            this.loiNhuan = ban - mua;
        }

        @Override
        public String toString(){
            return ma+" "+ten+" "+nhom+" "+String.format("%.2f", loiNhuan);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        List<MatHang> matHangs = new ArrayList<>();
        while (t-- > 0){
            matHangs.add(new MatHang(
                    sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble()
            ));
            sc.nextLine();
        }

        matHangs.sort((a, b) ->{
            return Double.compare(b.loiNhuan, a.loiNhuan);
        });

        for (MatHang matHang : matHangs){
            System.out.println(matHang);
        }
    }
}
