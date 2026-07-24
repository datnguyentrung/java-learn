package test.T2;

import java.util.Scanner;

public class B2 {
    static class NhanVien {
        String hoTen, chucVu;
        long luongcb;
        int soNgay;

        public void input(Scanner input) {
            this.hoTen = chuanHoa(input.nextLine());
            this.luongcb = Long.parseLong(input.nextLine());
            this.soNgay = Integer.parseInt(input.nextLine());
            this.chucVu = input.nextLine();
        }

        private String chuanHoa(String hoTen) {
            String[] line = hoTen.trim().toLowerCase().split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (String tu : line) {
                sb.append(Character.toUpperCase(tu.charAt(0)))
                        .append(tu.substring(1))
                        .append(" ");
            }
            return sb.toString().trim();
        }

        public double getPhuCap(String chucVu) {
            switch (chucVu) {
                case "GD":
                    return 250000;
                case "PGD":
                    return 200000;
                case "TP":
                    return 180000;
                case "NV":
                    return 150000;
                default:
                    return 0;
            }
        }

        public double getThuNhap(int soNgay) {
            double thuong = 0;
            if (soNgay >= 25) thuong = 0.2 * luongcb*soNgay;
            else if (soNgay >= 22) {
                thuong = 0.1 * luongcb*soNgay;
            } else thuong = 0;

            return thuong + luongcb*soNgay + getPhuCap(chucVu);
        }

        @Override
        public String toString() {
            double luongThang = luongcb * soNgay;
            double phuCap = getPhuCap(chucVu);
            double thuNhap = getThuNhap(soNgay);

            return hoTen + " "
                    + String.format("%.01f", luongThang) + " "
                    + String.format("%.01f", phuCap) + " "
                    + String.format("%.01f", thuNhap);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        NhanVien nv = new NhanVien();
        nv.input(in);
        System.out.println(nv);
    }
}
