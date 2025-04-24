import java.util.List;

/**
 * Kelas untuk laporan hasil pemeriksaan radiologi.
 * Mendukung berbagai jenis pemeriksaan (X-Ray, CT Scan, dll)
 */
public class RadiologyReport extends MedicalRecordBase<RadiologyReport.ReportData> {
    
    /**
     * Constructor dengan validasi temuan
     */
    public RadiologyReport(String recordId, ExamType type, List<String> findings) {
        super(recordId, new ReportData(type, findings));
        validateFindings(findings);
    }

    /**
     * Jenis pemeriksaan radiologi
     */
    public enum ExamType { 
        X_RAY,     // Sinar-X biasa
        CT_SCAN,   // CT Scan
        MRI        // Magnetic Resonance Imaging
    }

    /**
     * Record untuk data laporan
     */
    public record ReportData(
        ExamType examType,    // Jenis pemeriksaan
        List<String> findings // Daftar temuan medis
    ) implements MedicalRecord.Identifiable {
        @Override 
        public String getId() { 
            return examType.name();  // ID dari jenis pemeriksaan
        }
    }

    // Validasi temuan tidak boleh kosong
    private void validateFindings(List<String> findings) {
        if(findings == null || findings.isEmpty()) {
            throw new IllegalArgumentException("Harus ada minimal 1 temuan");
        }
    }

    @Override
    public String toString() {
        return String.format("Radiologi[%s] %s (%d temuan)", 
            getRecordId(), 
            getData().examType(), 
            getData().findings().size());
    }
}