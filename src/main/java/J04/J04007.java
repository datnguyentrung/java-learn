package J04;

import java.util.Scanner;

public class J04007 {
    static class NhanVien{
        String ten, gioiTinh, ngaySinh, diaChi, ma, ngayKy;

        String chuanHoa(String ngay){
            String[] list = ngay.trim().split("/");
            StringBuilder sb = new StringBuilder();

            if (list[0].length() == 1) sb.append("0");
            sb.append(list[0]).append("/");

            if (list[1].length() == 1) sb.append("0");
            sb.append(list[1]).append("/");

            sb.append(list[2]);

            return sb.toString();
        }

        public NhanVien(String ten, String gioiTinh, String ngaySinh, String diaChi, String ma, String ngayKy) {
            this.ten = ten;
            this.gioiTinh = gioiTinh;
            this.ngaySinh = chuanHoa(ngaySinh);
            this.diaChi = diaChi;
            this.ma = ma;
            this.ngayKy = chuanHoa(ngayKy);
        }

        @Override
        public String toString(){
            return "00001 " + ten +" "+gioiTinh+" "+ ngaySinh+" "+diaChi+" "+ma+" "+ngayKy;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new NhanVien(
                sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()
        ));
    }
}
