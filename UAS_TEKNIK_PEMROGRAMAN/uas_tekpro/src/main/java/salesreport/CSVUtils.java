package salesreport;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVUtils {
    public static final String CSV_HEADER = "ID, Name, Department, Salary\n";
    
    public static void writeToCSV(List<Employee> employees, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)){
            writer.append(CSV_HEADER).append("\n");
            
            for (Employee emp : employees){
                writer.append(String.valueOf(emp.getId())).append("|");
                writer.append(emp.getName()).append("|");
                writer.append(emp.getDepartment()).append("|");
                writer.append(String.valueOf(emp.getSalary())).append("\n");
            }
        }
    }
}