package RMI;

import java.io.Serializable;

public class TicketSla implements Serializable {
    private static final long serialVersionUID = 20260517L;

    private String ticketId;
    private String priority;      // LOW, MEDIUM, HIGH, CRITICAL
    private int openedHoursAgo;
    private boolean breached;
    private String action;

    public TicketSla() {
    }

    public TicketSla(
            String ticketId,
            String priority,
            int openedHoursAgo
    ) { /* gán 3 thuộc tính */ }
    // getter/setter cho tất cả thuộc tính

    public void chuanHoa() {
        switch (priority){
            case "CRITICAL":
                breached = openedHoursAgo > 2;
                break;
            case "HIGH":
                breached = openedHoursAgo > 8;
                break;
            case "MEDIUM":
                breached = openedHoursAgo > 24;
                break;
            default:
                breached = openedHoursAgo > 72;
                break;
        }

        if (!breached) action = "MONITOR";
        else if (priority.equals("CRITICAL") || openedHoursAgo > 96) {
            action = "ESCALATE_L2";
        } else action = "ESCALATE_L1";
    }
}