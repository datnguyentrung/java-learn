package TCP.NIOStream;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Yl8r2htp {
    static void readFully(SocketChannel channel, ByteBuffer buffer)
            throws IOException {

        while (buffer.hasRemaining()) {
            if (channel.read(buffer) == -1) {
                throw new IOException("Server closed connection");
            }
        }
    }

    static String readFrame(SocketChannel channel)
            throws IOException {

        // 4 byte length
        ByteBuffer lenBuf = ByteBuffer.allocate(4);
        readFully(channel, lenBuf);

        lenBuf.flip();
        int length = lenBuf.getInt();

        // payload
        ByteBuffer dataBuf = ByteBuffer.allocate(length);
        readFully(channel, dataBuf);

        dataBuf.flip();

        return StandardCharsets.UTF_8
                .decode(dataBuf)
                .toString();
    }

    static void writeFrame(SocketChannel channel, String data)
            throws IOException {

        byte[] bytes = data.getBytes(StandardCharsets.UTF_8);

        ByteBuffer buffer =
                ByteBuffer.allocate(4 + bytes.length);

        buffer.putInt(bytes.length);
        buffer.put(bytes);

        buffer.flip();

        while (buffer.hasRemaining()) {
            channel.write(buffer);
        }
    }

    public static void main(String[] args) throws IOException {

        String sCode = "B23DCCN142";
        String qCode = "fkdRJYuX";

        try (
                SocketChannel channel = SocketChannel.open(
                        new InetSocketAddress(
                                "36.50.135.242",
                                2211
                        )
                )
        ) {

            // a. gửi studentCode;qCode
            writeFrame(
                    channel,
                    sCode + ";" + qCode
            );

            // b. nhận ĐÚNG 3 frame
            String frame1 = readFrame(channel);
            String frame2 = readFrame(channel);
            String frame3 = readFrame(channel);

            String http =
                    frame1 + frame2 + frame3;

            System.out.println(http);

            // c. parse HTTP
            String[] lines = http.split("\r\n");

            // dòng đầu:
            // GET /abc?id=123 HTTP/1.1
            String[] firstLine = lines[0].split(" ");

            String method = firstLine[0];
            String path = firstLine[1];

            String host = "";

            for (String line : lines) {
                if (line.startsWith("Host:")) {
                    host = line.substring(5).trim();
                    break;
                }
            }

            String result =
                    method + ";" +
                            path + ";" +
                            host;

            System.out.println("Result = " + result);

            writeFrame(channel, result);
        }
    }
}
