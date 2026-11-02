package UDP;

import java.io.IOException;
import java.net.*;

public class zcgg4KSs {
    static String chuanHoa(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("36.50.135.242");

        String msg = ";B23DCCN142;zcgg4KSs";
        byte[] data = msg.getBytes();
        socket.send(new DatagramPacket(data, data.length, ip, 2208));

        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        String[] parts = new String(packet.getData(), 0, packet.getLength()).split(";");
        String requestId = parts[0];
        StringBuilder sb = new StringBuilder(requestId).append(";");
        for (String s : parts[1].trim().split("\\s+")){
            sb.append(chuanHoa(s)).append(" ");
        }
        sb.trimToSize();

        data = sb.toString().getBytes();
        socket.send(new DatagramPacket(data, data.length, ip, 2208));
        socket.close();
    }
}
