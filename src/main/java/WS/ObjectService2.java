package WS;

import WS.ObjectService.Customer;
import WS.ObjectService.ObjectService;
import WS.ObjectService.SoapObjectService;

import java.util.List;
import java.util.stream.Collectors;

public class ObjectService2 {
    public static void main(String[] args) {
        String sCode = "B23DCCN142";
        String qCode = "kUVwU3jj";

        // Kết nối ObjectService
        ObjectService objectService = new ObjectService();
        SoapObjectService service = objectService.getSoapObjectServicePort();

        // a. Nhận danh sách Customer
        List<Customer> data = service.requestListCustomer(sCode, qCode);

        // b. Lọc khách hàng theo Expected của server
        List<Customer> res = data.stream()
                .filter(c -> c.getTotalSpent() > 500
                        && c.getPurchaseCount() >= 3)
                .collect(Collectors.toList());

        // c. Gửi kết quả về server
        service.submitListCustomer(sCode, qCode, res);
    }
}