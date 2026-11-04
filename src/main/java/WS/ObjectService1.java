package WS;

import WS.ObjectService.*;

import java.util.List;

public class ObjectService1 {
    public static void main(String[] args) {
        String studentCode = "B23DCCN142";
        String qCode = "FoiPTrNs";

        // Khởi tạo SOAP Client
        ObjectService objectService = new ObjectService();
        SoapObjectService service = objectService.getSoapObjectServicePort();

        // a. Lấy danh sách nhân viên
        List<EmployeeY> data = service.requestListEmployeeY(
                studentCode,
                qCode
        );

        // b. Sắp xếp theo ngày bắt đầu làm việc tăng dần
        // Ngày sớm nhất = thâm niên cao nhất
        data.sort((a, b) -> Long.compare(
                a.getStartDate().toGregorianCalendar().getTimeInMillis(),
                b.getStartDate().toGregorianCalendar().getTimeInMillis()
        ));

        // c. Gửi danh sách đã sắp xếp về server
        service.submitListEmployeeY(
                studentCode,
                qCode,
                data
        );

        // d. Kết thúc
        System.out.println("Sorted successfully!");
    }
}
