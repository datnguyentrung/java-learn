package WS;

import WS.CharacterService.*;

import java.util.Collections;
import java.util.List;

public class CharacterService1 {
    public static void main(String[] args) {
        String studentCode = "B23DCCN142";
        String qCode = "Xgb8mVex";

        // Khởi tạo SOAP Client
        CharacterService characterService = new CharacterService();
        SoapCharacterService service =
                characterService.getSoapCharacterServicePort();

        // a. Nhận danh sách mã ASCII từ server
        List<Integer> data = service.requestCharacter(studentCode, qCode);

        // b. Xoay vòng phải theo mã ASCII của ký tự đầu tiên
        if (data != null && !data.isEmpty()) {
            int k = data.get(0);
            Collections.rotate(data, k % data.size());
        }

        // c. Gửi kết quả về server
        service.submitCharacterCharArray(studentCode, qCode, data);

        // d. Kết thúc
        System.out.println("Result: " + data);
    }
}
