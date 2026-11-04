package danhsachsinhvien1;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class J07013 {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("SV.in")
                )
        );

        ArrayList<SinhVien> sinhViens = (ArrayList<SinhVien>) inputStream.readObject();

        for (SinhVien sinhVien : sinhViens) {
            System.out.println(sinhVien);
        }
    }
}
