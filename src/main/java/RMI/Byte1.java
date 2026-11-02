package RMI;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Byte1 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        String studentCode = "B23DCCN142";
        String qCode = "6koTIBli";

        Registry registry = LocateRegistry.getRegistry("36.50.135.242");
        ByteService service = (ByteService) registry.lookup("RMIByteService");

        // a. Nhận mảng byte từ Server
        byte[] data = service.requestData(studentCode, qCode);

        // b. Tìm phần tử xuất hiện ít nhất
        int[] count = new int[256];
        for (byte b : data)
            count[b & 0xFF]++;

        byte minValue = data[0];
        int minCount = count[minValue & 0xFF];

        for (byte b : data) {
            if (count[b & 0xFF] < minCount) {
                minValue = b;
                minCount = count[b & 0xFF];
            }
        }

        byte[] result = {minValue, (byte) minCount};

        // c. Gửi kết quả về Server
        service.submitData(studentCode, qCode, result);

    }
}
