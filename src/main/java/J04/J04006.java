package J04;

import java.util.List;
import java.util.Scanner;

public class J04006 {
    static class SinhVien{
        String ten, lop, sinh;
        float diem;

        String chuanHoa(String sinh){
            String[] list = sinh.trim().split("/");
            StringBuilder sb = new StringBuilder();

            if (list[0].length() == 1) sb.append("0");
            sb.append(list[0]).append("/");

            if (list[1].length() == 1) sb.append("0");
            sb.append(list[1]).append("/");

            sb.append(list[2]);

            return sb.toString();
        }

        public SinhVien(String ten, String lop, String sinh, float diem) {
            this.ten = ten;
            this.lop = lop;
            this.sinh = chuanHoa(sinh);
            this.diem = diem;
        }

        @Override
        public String toString(){
            return "B20DCCN001 " + ten + " " + lop + " " + sinh + " " +  String.format("%.2f", diem);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new SinhVien(
                sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextFloat()
        ));
    }
}
