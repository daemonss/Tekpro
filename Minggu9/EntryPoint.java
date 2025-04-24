import java.time.LocalDate;
import java.util.List;

public class EntryPoint {
    public static void main(String[] args) {
        // 1. Inisialisasi repositori
        GenericRepository<PatientData> patientRepo = new GenericRepository<>();
        GenericRepository<Prescription> prescriptionRepo = new GenericRepository<>();
        GenericRepository<LabResult> labRepo = new GenericRepository<>();
        GenericRepository<DoctorNote> notesRepo = new GenericRepository<>();
        GenericRepository<RadiologyReport> radiologyRepo = new GenericRepository<>();

        // 2. Contoh data pasien (ID valid: PAT-001)
        patientRepo.addRecord(new PatientData(
            "PAT-001", 
            new PatientData.BioData(
                "PT-001", 
                "Budi Santoso", 
                LocalDate.of(1990, 8, 20), 
                PatientData.BloodType.A)
        ));

        // 3. Contoh resep obat (ID diubah ke PRE-001)
        prescriptionRepo.addRecord(new Prescription(
            "PRE-001",  // Diubah dari "RX-001" → "PRE-001"
            new Prescription.Medication(
                "MED-001", 
                "Amoxicillin", 
                "C16H19N3O5S"),
            new Prescription.Dosage(500, "mg", "3x sehari")
        ));

        // 4. Contoh hasil lab (ID valid: LAB-001)
        labRepo.addRecord(new LabResult("LAB-001", 98.6));
        
        // 5. Contoh catatan dokter (ID diubah ke DOC-001)
        notesRepo.addRecord(new DoctorNote(
            "DOC-001",  // Diubah dari "NOTE-001" → "DOC-001"
            "DOK-123", 
            "Pasien mengeluh pusing dan mual sejak pagi"
        ));

        // 6. Contoh laporan radiologi (ID valid: RAD-001)
        radiologyRepo.addRecord(new RadiologyReport(
            "RAD-001",
            RadiologyReport.ExamType.X_RAY,
            List.of("Fraktur tulang lengan", "Tidak ada perdarahan")
        ));

        // 7. Tampilkan semua data
        System.out.println("=== SISTEM MEDIVAULT ===");
        GenericRepository.printAll(patientRepo);
        GenericRepository.printAll(prescriptionRepo);
        GenericRepository.printAll(labRepo);
        GenericRepository.printAll(notesRepo);
        GenericRepository.printAll(radiologyRepo);
    }
}