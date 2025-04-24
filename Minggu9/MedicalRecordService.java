/**
 * Kelas layanan dengan operasi umum untuk rekam medis
 */
public class MedicalRecordService {
    /**
     * Membandingkan dua rekam medis berdasarkan ID
     */
    public static <T extends MedicalRecord<?>> boolean compareRecords(T record1, T record2) {
        return record1.getRecordId().equals(record2.getRecordId());
    }
    
    /**
     * Mencetak ringkasan rekam medis
     */
    public static void printRecordSummary(MedicalRecord<?> record) {
        System.out.printf("[RINGKASAN] %s | Jenis: %s%n",
            record.getRecordId(),
            record.getClass().getSimpleName()
        );
    }
}