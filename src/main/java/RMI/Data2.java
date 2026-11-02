package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data2 {
    public static void main(String[] args) throws Exception{
        String sCode = "B23DCCN142";
        String qCode = "qd9NJbR6";

        Registry registry = LocateRegistry.getRegistry("36.50.135.242");
        DataService service = (DataService) registry.lookup("RMIDataService");

        String line = (String) service.requestData(sCode, qCode);

        double[] data = Arrays.stream(line.trim().split(","))
                        .mapToDouble(Double::parseDouble)
                                .toArray();

        double avg = Arrays.stream(data).average().orElse(0);

        double sum = 0;
        for (double x : data) {
            sum += Math.pow(x - avg, 2);
        }
        sum = Math.sqrt(sum/ data.length);

        Arrays.sort(data);
        double p95 = data[ (int) Math.ceil(data.length * 0.95) - 1];

        String res = String.format(
                "average=%.2f;stddev=%.2f;p95=%.2f",
                avg, sum, p95
        );

        service.submitData(sCode, qCode, res);
    }
}
