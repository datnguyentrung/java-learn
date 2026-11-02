package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Data1 {
    public static void main(String[] args) throws Exception{
        String sCode = "B23DCCN142";
        String qCode = "vqILccPZ";

        Registry registry = LocateRegistry.getRegistry("36.50.135.242");
        DataService service = (DataService) registry.lookup("RMIDataService");

        int[] data = (int[]) service.requestData(sCode, qCode);
        List<Integer> res = new ArrayList<>();
        if (data[0] > data[1]) res.add(1);

        int n = data.length;
        for (int i = 1; i < n-1; i++){
            if (data[i] > data[i-1] && data[i] > data[i+1]) {
                res.add(i+1);
            }
        }

        if (data[n-1] > data[n-2]) res.add(n);

        service.submitData(sCode, qCode, res);
    }
}
