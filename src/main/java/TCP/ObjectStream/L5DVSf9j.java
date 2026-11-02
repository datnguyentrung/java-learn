package TCP.ObjectStream;

import TCP.Laptop;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class L5DVSf9j {
    public static void main(String[] args) throws IOException {
        String sCode = "B23DCCN142";
        String qCode = "L5DVSf9j";

        try (Socket s = new Socket(
                "36.50.135.242",
                2209
        );
             ObjectInputStream in = new ObjectInputStream(s.getInputStream());
             ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream())
        ) {
            out.writeObject(sCode + ";" + qCode);
            out.flush();

            Laptop laptop = (Laptop) in.readObject();
            laptop.setName(laptop.getName());
            laptop.setQuantity(laptop.getQuantity());

            out.writeObject(laptop);
            out.flush();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
