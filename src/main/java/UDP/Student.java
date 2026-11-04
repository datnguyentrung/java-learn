package UDP;

import java.io.Serializable;
import java.util.Locale;

public class Student implements Serializable {
    private static final long serialVersionUID = 20171107;

    String id, code, name, email;

    public Student(String code) {
        this.code = code;
    }

    public Student(
            String id,
            String code,
            String name,
            String email
    ) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
    }

    void chuanHoaTen() {
        String[] line = name.trim().toLowerCase(Locale.ROOT).split(" ");

        StringBuilder sb = new StringBuilder();
        for (String s : line) {
            sb.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1))
                    .append(" ");
        }
        name = sb.toString().trim();
    }

    void chuanHoaEmail() {
        String[] line = name.trim().toLowerCase(Locale.ROOT).split(" ");

        StringBuilder sb = new StringBuilder(line[line.length-1]);
        for (int i = 0; i < line.length-1; i++) {
            sb.append(line[i].charAt(0));
        }
        email = sb.append("@ptit.edu.vn").toString().trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
