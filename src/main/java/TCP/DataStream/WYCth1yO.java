package TCP.DataStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class WYCth1yO {
    static String giaiMa(int n, String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') sb.append((char) ('A' + (c - 'A' - n + 26) % 26));
            else sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String sCode = "B23DCCN142";
        String qCode = "WYCth1yO";

        try (Socket s = new Socket(
                "36.50.135.242",
                2207
        );
             DataInputStream in = new DataInputStream(s.getInputStream());
             DataOutputStream out = new DataOutputStream(s.getOutputStream())
        ) {
            out.writeUTF(sCode + ";" + qCode);
            out.flush();

            String data = in.readUTF();
            int so = in.readInt();
            out.writeUTF(giaiMa(so, data));
            out.flush();
        }
    }
}
