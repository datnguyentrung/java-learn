package test.T3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class B1 {
    static class SV {
        String ma, ten, sdt, email;
        SV (Scanner sc) {
            ma = sc.nextLine();
            ten = sc.nextLine();
            sdt = sc.nextLine();
            email = sc.nextLine();
        }
    }

    static class DT {
        String ma, gv, ten;

        DT (Scanner sc, int i) {
            ma = String.format("DT%03d", i);
            gv = sc.nextLine();
            ten = sc.nextLine();
        }
    }

    static class NV {
        SV sv;
        DT dt;

        NV (SV sv, DT dt) {
            this.sv = sv;
            this.dt = dt;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s1 = new Scanner(new File("SINHVIEN.in"));
        Scanner s2 = new Scanner(new File("DETAI.in"));
        Scanner s3 = new Scanner(new File("NHIEMVU.in"));

        Map<String, SV> svMap = new HashMap<>();
        Map<String, DT> dtMap = new HashMap<>();

        int n = Integer.parseInt(s1.nextLine());
        while (n-->0) {
            SV x = new SV(s1);
            svMap.put(x.ma, x);
        }

        n = Integer.parseInt(s2.nextLine());
        for (int i = 1; i <= n; i++){
            DT x = new DT(s2, i);
            dtMap.put(x.ma, x);
        }

        List<NV> nvs = new ArrayList<>();
        n = Integer.parseInt(s3.nextLine());

        while (n-->0) {
            String[] a = s3.nextLine().trim().split("\\s+");
            nvs.add(new NV(svMap.get(a[0]), dtMap.get(a[1])));
        }

        nvs.sort((a, b) -> {
            return a.dt.ten.compareTo(b.dt.ten);
        });

        for (NV x : nvs) {
            System.out.println(
                    x.sv.ma+ " "+
                            x.sv.ten+" "+
                            x.sv.sdt+" "+
                            x.sv.email+" "+
                            x.dt.gv+" "+
                            x.dt.ten
            );
        }
    }
}
