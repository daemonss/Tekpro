/**
 * Kelas untuk hasil pemeriksaan laboratorium.
 * Menggunakan tipe double untuk nilai numerik.
 */
public class LabResult extends MedicalRecordBase<LabResult.LabData> {
    /**
     * Constructor dengan validasi nilai
     */
    public LabResult(String recordId, double value) {
        super(recordId, new LabData(value));
        validateValue(value);
    }

    /**
     * Record untuk menyimpan nilai lab (diubah menjadi public static)
     */
    public static record LabData(double value) implements MedicalRecord.Identifiable {
        @Override
        public String getId() {
            return String.valueOf(value);
        }
    }

    // Validasi nilai lab tidak boleh negatif
    private void validateValue(double value) {
        if (value < 0 || value > 1000) {
            throw new IllegalArgumentException("Nilai lab tidak valid: " + value);
        }
    }

    @Override
    public String toString() {
        return String.format("Lab[%s] %.2f", getRecordId(), getData().value());
    }
}