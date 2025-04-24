import java.time.LocalDate;

/**
 * Kelas untuk catatan dokter dengan validasi panjang teks.
 * Menggunakan String sebagai tipe data utama.
 */
public class DoctorNote extends MedicalRecordBase<DoctorNote.NoteContent> {
    
    /**
     * Constructor dengan validasi catatan
     */
    public DoctorNote(String recordId, String doctorId, String notes) {
        super(recordId, new NoteContent(doctorId, LocalDate.now(), notes));
        validateNotes(notes);
    }

    /**
     * Record untuk konten catatan
     */
    public record NoteContent(
        String doctorId,   // ID dokter penanggung jawab
        LocalDate date,    // Tanggal catatan
        String notes       // Isi catatan (maks 500 karakter)
    ) implements MedicalRecord.Identifiable {
        @Override 
        public String getId() { 
            return doctorId + "-" + date;  // ID unik catatan
        }
    }

    // Validasi panjang catatan
    private void validateNotes(String notes) {
        if(notes == null || notes.length() > 500) {
            throw new IllegalArgumentException("Catatan tidak valid (maks 500 karakter)");
        }
    }

    @Override
    public String toString() {
        return String.format("Catatan[%s] Dr.%s: %.20s...", 
            getRecordId(), 
            getData().doctorId(), 
            getData().notes());
    }
}