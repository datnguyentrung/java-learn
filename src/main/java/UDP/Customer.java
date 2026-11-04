package UDP;

import java.io.Serializable;
import java.util.Locale;

public class Customer implements Serializable {
    private static final long serialVersionUID = 20151107;

    String id, code, name, dayOfBirth, userName;

    public Customer(
            String id,
            String code,
            String name,
            String dayOfBirth,
            String userName
    ) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
    }

    void chuanHoa(){
        StringBuilder name = new StringBuilder();
        StringBuilder date = new StringBuilder();
        StringBuilder userName = new StringBuilder();

        String[] line = this.name.trim().toLowerCase(Locale.ROOT).split(" ");

        name.append(line[line.length-1].toUpperCase()).append(", ");
        for (int i = 0; i < line.length-1; i++) {
            String s = line[i];
            name.append(Character.toUpperCase(s.charAt(0)))
                    .append(s.substring(1))
                    .append(" ");
        }

        for (int i = 0; i < line.length-1; i++) {
            String s = line[i];
            userName.append(s.charAt(0));
        }
        userName.append(line[line.length-1]);

        line = this.dayOfBirth.split("-");
        date.append(line[1]).append("/")
                .append(line[0]).append("/")
                .append(line[2]);

        this.name = name.toString().trim();
        this.userName = userName.toString();
        this.dayOfBirth = date.toString();
    }
}
