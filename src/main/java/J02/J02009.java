package J02;

import java.math.BigInteger;
import java.util.*;

public class J02009 {
    static class KhachHang{
        int time, duration;

        public KhachHang(int time, int duration) {
            this.time = time;
            this.duration = duration;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int ans = 0;
        List<KhachHang> list = new ArrayList<>();
        while (t-->0){
            list.add(new KhachHang(sc.nextInt(), sc.nextInt()));
        }

        list.sort((a, b) ->{
            return a.time - b.time;
        });

        for (KhachHang kh : list){
            if (kh.time > ans) ans = kh.time;

            ans += kh.duration;
        }

        System.out.println(ans);
    }
}
