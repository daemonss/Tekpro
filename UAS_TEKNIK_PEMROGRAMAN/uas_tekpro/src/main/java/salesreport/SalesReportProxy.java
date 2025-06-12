package salesreport;

public class SalesReportProxy implements SalesReport {
    private String summary;
    private DetailsofSalesReport detailsofSalesReport;

    public SalesReportProxy(String summary) {
        this.summary = summary;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public String getDetailsofReport() {
        if (detailsofSalesReport == null) {
            detailsofSalesReport = new DetailsofSalesReport(summary);
        }
        return detailsofSalesReport.getDetailsofReport();
    }
}