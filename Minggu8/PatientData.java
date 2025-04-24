import java.time.LocalDate;

/**
 * Kelas untuk menyimpan data pasien.
 * Menggunakan BioData sebagai tipe data spesifik.
 */
public class PatientData extends MedicalRecordBase<PatientData.BioData> {
    
    /**
     * Constructor utama
     * @param recordId Format: PAT-001
     * @param data Biodata pasien
     */
    public PatientData(String recordId, BioData data) {
        super(recordId, data);
    }

    /**
     * Record untuk data biometrik pasien
     */
    public record BioData(
        String id,          // ID pasien unik
        String name,        // Nama lengkap
        LocalDate dob,     // Tanggal lahir
        BloodType bloodType // Golongan darah
    ) implements MedicalRecord.Identifiable {
        @Override public String getId() { return id; }
    }

    /**
     * Enum untuk golongan darah
     */
    public enum BloodType { O, A, B, AB }

    @Override
    public String toString() {
        return String.format("Pasien[%s] %s | Darah: %s", 
            getRecordId(), getData().name(), getData().bloodType());
    }
}