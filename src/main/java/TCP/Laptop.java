package TCP;

import java.io.Serial;
import java.io.Serializable;

public class Laptop implements Serializable {
    @Serial
    private static final long serialVersionUID = 20150711L;

    int id;
    String code;
    String name;
    int quantity;

    public Laptop(
            int id,
            String code,
            String name,
            int quantity
    ) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }

    public void setName(String name) {
        String[] s = name.trim().split(" ");
        StringBuilder sb = new StringBuilder(s[s.length-1]).append(" ");
        for (int i = 1; i < s.length-1; i++) {
            sb.append(s[i]).append(" ");
        }
        sb.append(s[0]);
        this.name = sb.toString();
    }

    public void setQuantity(int quantity){
        String s = String.valueOf(quantity);
        this.quantity = Integer.parseInt(new StringBuilder(s).reverse().toString());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
