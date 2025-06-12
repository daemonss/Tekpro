package salesreport;

public class POSApplication {
    public static void main(String[] args) {
        SalesReport report = new SalesReportProxy("Sales Summary for Q1 2025");
        System.out.println("Sales Summary: " + report.getSummary());
        System.out.println("Requesting detailed report...");
        String detailsofReport = report.getDetailsofReport();
        System.out.println(detailsofReport);
    }
}
