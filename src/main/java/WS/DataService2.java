package WS;

import WS.DataService.DataService;
import WS.DataService.SoapDataService;

import java.util.List;
import java.util.stream.Collectors;

public class DataService2 {
    public static void main(String[] args) {
        String studentCode = "B23DCCN142";
        String qCode = "PnebQblq";

        // Khởi tạo SOAP Client
        DataService dataService = new DataService();
        SoapDataService service = dataService.getSoapDataServicePort();

        // a. Lấy danh sách số nguyên từ server
        List<Integer> data = service.getData(studentCode, qCode);

        // b. Tính tổng tất cả phần tử
        int sum = data.stream()
                .mapToInt(Integer::intValue)
                .sum();

        // c. Gửi kết quả về server
        service.submitDataInt(studentCode, qCode, sum);
    }
}
