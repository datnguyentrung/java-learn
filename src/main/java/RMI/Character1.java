package RMI;

import java.net.URI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Character1 {
    public static void main(String[] args) throws Exception {
        String sCode = "B23DCCN142";
        String qCode = "6xgxYJGm";

        Registry registry = LocateRegistry.getRegistry("36.50.135.242");
        CharacterService service = (CharacterService) registry.lookup("RMICharacterService");

        String data = service.requestCharacter(sCode, qCode);
        String encoded = new URI(null, null, data, null).toASCIIString();

        service.submitCharacter(sCode, qCode, encoded);
    }
}
