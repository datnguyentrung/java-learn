package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class S50pjD8N {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("36.50.135.242");

        String msg = ";B23DCCN142;S50pjD8N";
        byte[] data = msg.getBytes();
        socket.send(new DatagramPacket(data,data.length, ip, 2207));

        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        String[] parts = new String(packet.getData(), 0, packet.getLength()).split(";");
        String requestId = parts[0];
        String chuoi = parts[1];

        Map<Character, Integer> map = new LinkedHashMap<>();
        Map<Character, List<Integer>> mp2 = new HashMap<>();
        for (int i = 0; i < chuoi.length(); i++) {
            char c = chuoi.charAt(i);

            map.put(c, map.getOrDefault(c, 0)+1);
            mp2.computeIfAbsent(c, k -> new ArrayList<>()).add(i+1);
        }

        int cnt = -1;
        char key = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (cnt < entry.getValue()) {
                cnt = entry.getValue();
                key = entry.getKey();
            }
        }

        StringBuilder sb = new StringBuilder(requestId)
                .append(";").append(key).append(":");
        for (Integer num : mp2.get(key)){
            sb.append(num).append(",");
        }

        data = sb.toString().getBytes();
        socket.send(new DatagramPacket(data, data.length, ip, 2207));
        socket.close();
    }
}
