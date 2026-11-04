package WS;

import WS.CharacterService.*;

import java.util.*;

public class CharacterService2 {
    public static void main(String[] args) {
        String sCode = "B23DCCN142";
        String qCode = "hNxTP7wt";

        CharacterService characterService = new CharacterService();
        SoapCharacterService service = characterService.getSoapCharacterServicePort();

        // a. Nhận danh sách chuỗi
        List<String> data = service.requestStringArray(sCode, qCode);

        // Key: số nguyên âm
        // Value: danh sách các từ có cùng số nguyên âm
        Map<Integer, List<String>> groups = new TreeMap<>();

        // b. Phân nhóm theo số lượng nguyên âm
        for (String word : data) {
            int count = 0;

            for (char c : word.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(c) >= 0) {
                    count++;
                }
            }

            groups.computeIfAbsent(count, k -> new ArrayList<>())
                    .add(word);
        }

        List<String> result = new ArrayList<>();

        // Sắp xếp từng nhóm và ghép bằng dấu phẩy
        for (List<String> group : groups.values()) {
            Collections.sort(group);

            result.add(String.join(",", group));
        }

        // c. Gửi kết quả về server
        service.submitCharacterStringArray(
                sCode,
                qCode,
                result
        );
    }
}