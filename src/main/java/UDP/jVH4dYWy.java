package UDP;

import java.io.IOException;
import java.net.*;

public class jVH4dYWy {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("36.50.135.242");

        String msg = ";B23DCCN142;jVH4dYWy";
        byte[] data = msg.getBytes();
        socket.send(new DatagramPacket(data, data.length, ip, 2207));

        byte[] buff = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        socket.receive(packet);

        String[] parts = new String(packet.getData(), 0, packet.getLength()).split(";");
        String requestId = parts[0];
        String chuoi = parts[1];

        int min = (int) 1e5, max = (int) -1e5;

        for (String c : chuoi.split(",")) {
            min = Math.min(min, Integer.parseInt(c));
            max = Math.max(max, Integer.parseInt(c));
        }

        data = (requestId +";"+max+","+min).getBytes();
        socket.send(new DatagramPacket(data, data.length, ip, 2207));
        socket.close();
    }
}
