package J06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J06009 {
    static int kh = 1, mh = 1, hd = 1;
    static List<KH> khs = new ArrayList<>();
    static List<MH> mhs = new ArrayList<>();
    static List<HD> hds = new ArrayList<>();

    static class KH {
        String ma, ten, gioiTinh, sinh, diaChi;

        public KH(String ten, String gioiTinh, String sinh, String diaChi) {
            this.ma = String.format("KH%03d", kh++);
            this.ten = ten;
            this.gioiTinh = gioiTinh;
            this.sinh = sinh;
            this.diaChi = diaChi;
        }
    }

    static class MH {
        String ma, ten, donVi;
        Integer mua, ban;

        public MH(String ten, String donVi, Integer mua, Integer ban) {
            this.ma = String.format("MH%03d", mh++);
            this.ten = ten;
            this.donVi = donVi;
            this.mua = mua;
            this.ban = ban;
        }
    }

    static class HD {
        String ma;
        KH kh;
        MH mh;
        int soLuong;

        public HD(KH kh, MH mh, int soLuong) {
            this.ma = String.format("HD%03d", hd++);
            this.kh = kh;
            this.mh = mh;
            this.soLuong = soLuong;
        }

        @Override
        public String toString(){
            return ma+" "+ kh.ten+" "+kh.diaChi+" "+mh.ten+" "+mh.donVi+" "+ mh.donVi+" "
                    +mh.mua+" "+mh.ban+" "+soLuong+" "+(soLuong*mh.ban);
        }
    }

    static KH findKH(String ma){
        for (KH item : khs) {
            if (item.ma.equals(ma)){
                return item;
            }
        }
        return null;
    }

    static MH findMH(String ma){
        for (MH item : mhs) {
            if (item.ma.equals(ma)){
                return item;
            }
        }
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scKH = new Scanner(new File("KH.in"));
        Scanner scMH = new Scanner(new File("MH.in"));
        Scanner scHD = new Scanner(new File("HD.in"));

        int t = Integer.parseInt(scKH.nextLine().trim());
        while (t-->0){
            khs.add(new KH(
                    scKH.nextLine(),scKH.nextLine(),scKH.nextLine(),scKH.nextLine()
            ));
        }

        t = Integer.parseInt(scMH.nextLine().trim());
        while (t-->0){
            mhs.add(new MH(
                    scMH.nextLine(), scMH.nextLine(),
                    Integer.parseInt(scMH.nextLine()),
                    Integer.parseInt(scMH.nextLine())
            ));
        }

        t = Integer.parseInt(scHD.nextLine().trim());
        while (t-->0){
            String[] line = scHD.nextLine().trim().split("\\s+");

            hds.add(new HD(
                    findKH(line[0]),
                    findMH(line[1]),
                    Integer.parseInt(line[2])
            ));
        }

        for (HD item : hds) {
            System.out.println(item);
        }
    }
}
