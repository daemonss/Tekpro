/**
 * Kelas untuk mengelola resep obat dengan validasi dosis.
 * Menggunakan dua record: Medication (data obat) dan Dosage (aturan pakai)
 */
public class Prescription extends MedicalRecordBase<Prescription.Medication> {
    private final Dosage dosage;  // Aturan pakai obat
    
    /**
     * Constructor dengan validasi dosis
     */
    public Prescription(String recordId, Medication medication, Dosage dosage) {
        super(recordId, medication);
        validateDosage(dosage);
        this.dosage = dosage;
    }

    /**
     * Record untuk data obat
     */
    public record Medication(
        String id, 
        String name, 
        String chemicalFormula  // Rumus kimia
    ) implements MedicalRecord.Identifiable {
        @Override public String getId() { return id; }
    }

    /**
     * Record untuk aturan pakai obat
     */
    public record Dosage(
        double value,     // Jumlah (misal: 500)
        String unit,      // Satuan (misal: mg)
        String frequency  // Frekuensi (misal: 3x sehari)
    ) {
        // Validasi saat objek dibuat
        public Dosage {
            if(value <= 0) throw new IllegalArgumentException("Dosis harus > 0");
        }
    }

    // Validasi dosis berbahaya
    private void validateDosage(Dosage dosage) {
        if(dosage.unit().equals("mg") && dosage.value() > 1000) {
            throw new IllegalArgumentException("Dosis melebihi batas aman!");
        }
    }

    @Override
    public String toString() {
        return String.format("Resep[%s] %s - %s %s (%s)", 
            getRecordId(), 
            getData().name(), 
            dosage.value(), 
            dosage.unit(), 
            dosage.frequency());
    }
}