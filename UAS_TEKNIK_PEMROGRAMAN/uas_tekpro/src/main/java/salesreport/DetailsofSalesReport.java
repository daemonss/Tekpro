package salesreport;


import java.util.Arrays;
import java.util.List;
import java.io.IOException;

public class DetailsofSalesReport implements SalesReport {
    private String summary;
    private String detailsofReport;
    List<Employee> employees = Arrays.asList(
        new Employee(1, "Ahmad", "Engineering", 10000000),
        new Employee(2, "Asep", "Marketing", 10000000),
        new Employee(3, "Ujang", "HR", 10000000),
        new Employee(4, "Acoeg", "Sales", 10000000),
        new Employee(17, "Muhammad Arrafi Reva Razqana Arrasy", "Engineering", 10000000 + 17)
    );

    public DetailsofSalesReport(String summary) {
        this.summary = summary;
        this.detailsofReport = generateDetailsofReport();
    }

    private String generateDetailsofReport() {
        System.out.println("Generating detailed sales report...");
        try {
            String filePath = "employees.csv";
            CSVUtils.writeToCSV(employees, filePath);
            System.out.println("CSV file created: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Detailed Sales Report Content";
    }
    
    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public String getDetailsofReport() {
        return detailsofReport;
    }
}