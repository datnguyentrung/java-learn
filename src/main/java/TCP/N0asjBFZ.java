package TCP;


import java.io.*;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;

public class N0asjBFZ {
    public static void main(String[] args) throws IOException {
        String sCode = "B23DCCN142";
        String qCode = "N0asjBFZ";

        try (Socket s = new Socket("36.50.135.242", 2208);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(s.getInputStream())
             );
             BufferedWriter out = new BufferedWriter(
                     new OutputStreamWriter(s.getOutputStream())
             )
        ) {
            out.write(sCode+";"+qCode);
            out.newLine();
            out.flush();

            String data = in.readLine();

            Map<Character, Integer> map = new LinkedHashMap<>();
            for (char c : data.toCharArray()){
                if (Character.isLetterOrDigit(c)){
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    sb.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
                }
            }

            out.write(sb.toString());
            out.newLine();
            out.flush();
        }

    }
}
