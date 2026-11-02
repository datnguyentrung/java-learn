package TCP.GZIPStream;

import java.io.IOException;
import java.net.Socket;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class iXfqcITq {
    public static void main(String[] args) throws IOException {
        String sCode = "B23DCCN142";
        String qCode = "iXfqcITq";

        try (Socket s = new Socket("36.50.135.242", 2210);
             GZIPInputStream in = new GZIPInputStream(s.getInputStream());
             GZIPOutputStream out = new GZIPOutputStream(s.getOutputStream(), true);
        ){
            out.write((sCode + ";" +qCode + "\n").getBytes());
            out.flush();

            byte[] buf = new byte[1024];
            int n = in.read(buf);
            String data = new String(buf, 0, n).trim();

            String res = new StringBuilder(data).reverse().toString();
            String base64 = Base64.getEncoder()
                            .encodeToString(res.getBytes());

            out.write(
                    (res + "|" + base64 + "\n").getBytes()
            );
            out.flush();
            out.finish();
        }
    }
}
