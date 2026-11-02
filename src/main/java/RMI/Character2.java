package RMI;

import java.net.URI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Character2 {
    public static void main(String[] args) throws Exception {
        String sCode = "B23DCCN142";
        String qCode = "rxXkjuT2";

        Registry registry = LocateRegistry.getRegistry("36.50.135.242");
        CharacterService service = (CharacterService) registry.lookup("RMICharacterService");

        String data = service.requestCharacter(sCode, qCode);
        int num = Integer.parseInt(data);

        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]){
                res.append(roman[i]);
                num -= value[i];
            }
        }

        service.submitCharacter(sCode, qCode, res.toString());
    }
}
