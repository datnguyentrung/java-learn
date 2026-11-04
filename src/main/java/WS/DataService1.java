package WS;

import WS.DataService.*;

import java.util.List;
import java.util.stream.Collectors;

public class DataService1 {
    public static void main(String[] args) {
        String studentCode = "B23DCCN142";
        String qCode = "foBAY32l";

        // Khởi tạo SOAP Client
        DataService dataService = new DataService();
        SoapDataService service = dataService.getSoapDataServicePort();

        // a. Lấy danh sách số nguyên từ server
        List<Integer> data = service.getData(studentCode, qCode);

        // b. Sắp xếp để tạo số lớn nhất khi ghép các số
        String result = data.stream()
                .map(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining());

        // c. Gửi kết quả về server
        service.submitDataString(studentCode, qCode, result);
    }
}
