package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Byte2 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        String sCode = "B23DCCN142";
        String qCode = "dJ1Ve2a1";

        Registry registry = LocateRegistry.getRegistry("36.50.135.242");
        ByteService service = (ByteService) registry.lookup("RMIByteService");

        byte[] data = service.requestData(sCode, qCode);

        int[] cnt = new int[256];
        for (byte b : data) cnt[b & 0xFF]++;

        byte maxValue = data[0];
        int maxCnt = cnt[maxValue & 0xFF];

        for (byte b : data){
            if (cnt[b & 0xFF] > maxCnt) {
                maxCnt = cnt[b & 0xFF];
                maxValue = b;
            }
        }

        byte[] result = {maxValue, (byte) maxCnt};

        service.submitData(sCode, qCode, result);
    }
}
