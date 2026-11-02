package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Object1 {
    public static void main(String[] args) throws Exception{
        String sCode = "B23DCCN142";
        String qCode = "c3JDbhYH";

        Registry registry = LocateRegistry.getRegistry("36.50.135.242");
        ObjectService service = (ObjectService) registry.lookup("RMIObjectService");

        TicketSla ticketSla = (TicketSla) service.requestObject(sCode, qCode);
        ticketSla.chuanHoa();

        service.submitObject(sCode, qCode, ticketSla);
    }
}
