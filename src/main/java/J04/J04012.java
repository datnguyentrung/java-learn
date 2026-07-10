package J04;

import java.util.Scanner;

public class J04012 {
    static class NhanVien{
        private String ten;
        private Integer salary;
        private Integer soNgay;
        private String chucVu;

        public NhanVien(String ten, Integer salary, Integer soNgay, String chucVu) {
            this.ten = ten;
            this.salary = salary;
            this.soNgay = soNgay;
            this.chucVu = chucVu;
        }

        public Integer luongThang(){
            return salary * soNgay;
        }

        public Integer thuongThang(){
            Integer luongThang = luongThang();
            if (soNgay >= 25) return (int) (luongThang*0.2);
            else if (soNgay >= 22) return (int) (luongThang*0.1);
            else return 0;
        }

        public Integer phuCap() {
            switch (chucVu) {
                case "GD":
                    return 250000;
                case "PGD":
                    return 200000;
                case "TP":
                    return 180000;
                default:
                    return 150000;
            }
        }

        @Override
        public String toString(){
            return "NV01 "+ten+" "+luongThang()+" "+thuongThang()+" "+phuCap()+" "+(luongThang()+thuongThang()+phuCap());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new NhanVien(
                sc.nextLine(), sc.nextInt(),sc.nextInt(),sc.next()
                ));
    }
}
