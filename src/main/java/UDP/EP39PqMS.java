package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class EP39PqMS {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("36.50.135.242");

        String msg = ";B23DCCN142;EP39PqMS";
        byte[] data = msg.getBytes(StandardCharsets.UTF_8);
        socket.send(new DatagramPacket(data, data.length, ip, 2207));

        byte[] buff = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        socket.receive(packet);

        String[] line = new String(packet.getData(), 0, packet.getLength()).split(";");
        StringBuilder sb = new StringBuilder(line[0]).append(";");
        int n = Integer.parseInt(line[1]);

        Set<Integer> set = new HashSet<>();
        for (String s : line[2].split(",")) {
            set.add(Integer.parseInt(s));
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)){
                sb.append(i).append(",");
            }
        }
        sb.deleteCharAt(sb.length()-1);

        data = sb.toString().getBytes(StandardCharsets.UTF_8);
        socket.send(new DatagramPacket(data, data.length, ip, 2207));
    }
}
