package J08.J08011;

import java.util.*;

public class J08011 {
    public static boolean checkN(String n){
        for (int i = 1; i < n.length(); i++){
            if (n.charAt(i) < n.charAt(i-1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, So> mp = new HashMap<>();
        int stt = 0;
        while (sc.hasNext()){
            String n = sc.next();

            if (!checkN(n)){
                continue;
            }
            if (mp.get(n) == null){
                mp.put(n, new So(
                        n, stt, 1
                ));
                stt++;
            } else {
                // Lấy object hiện tại ra
                So currentSo = mp.get(n);

                // Cập nhật lại count
                currentSo.setCount(currentSo.getCount() + 1);
            }
        }

        List<So> soList = new ArrayList<>(mp.values());

        Collections.sort(soList);

        for (So so : soList) {
            System.out.println(so.getNumber() + " " + so.getCount());
        }
    }
}
