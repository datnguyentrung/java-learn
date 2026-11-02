package UDP;
import UDP.Student;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Obj1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("36.50.135.242");

        String msg = ";B23DCCN142;75TluAiB";
        byte[] data = msg.getBytes(StandardCharsets.UTF_8);
        socket.send(new DatagramPacket(data, data.length, ip, 2209));

        byte[] buff = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        socket.receive(packet);

        String requestId = new String(buff, 0, 8);

        ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(buff, 8, buff.length-8)
        );

        Student s = (Student) in.readObject();
        s.chuanHoaTen();
        s.chuanHoaEmail();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(requestId.getBytes(StandardCharsets.UTF_8));

        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(s);
        out.flush();

        data = baos.toByteArray();
        socket.send(new DatagramPacket(data, data.length, ip, 2209));
    }
}
