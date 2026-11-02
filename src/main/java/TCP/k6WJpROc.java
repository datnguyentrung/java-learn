package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class k6WJpROc {
    public static void main(String[] args) throws IOException {
        String sCode = "B23DCCN142";
        String qCode = "k6WJpROc";

        try (Socket s = new Socket("36.50.135.242", 2207);
             DataInputStream in = new DataInputStream(s.getInputStream());
             DataOutputStream out = new DataOutputStream(s.getOutputStream())
        ) {
            out.writeUTF(sCode + ";" + qCode);
            out.flush();

            int a = in.readInt();
            int b = in.readInt();

            int sum = a+b, tich = a*b;

            out.writeInt(sum);
            out.writeInt(tich);
            out.flush();
        }
    }
}
